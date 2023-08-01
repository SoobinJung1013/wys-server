import time
from apscheduler.schedulers.background import BackgroundScheduler
from django_apscheduler.jobstores import DjangoJobStore, register_events, register_job
from pymongo import MongoClient
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
from selenium import webdriver
from bs4 import BeautifulSoup

from config.settings import (
    MONGO_ADMIN, MONGO_PASSWORD, MONGO_HOST, MONGO_PORT, MONGO_DATABASE
)


client = MongoClient(
    f"mongodb://{MONGO_ADMIN}:{MONGO_PASSWORD}@{MONGO_HOST}:{MONGO_PORT}")
db = client[MONGO_DATABASE]
collection = db["danawa_cat_feed"]


Service = Service()
# Service = Service(ChromeDriverManager().install())
chrome_options = Options()
chrome_options.add_experimental_option("detach", True)


def danawa_cat_feed():

    driver = webdriver.Chrome(service=Service, options=chrome_options)
    driver.implicitly_wait(10)
    driver.maximize_window()

    keyword = "고양이사료"
    rank = 1
    done = False

    for page in range(1, 6):
        if done == True:
            break
        print(page, "번째 페이지 입니다. ")
        main_url = f"https://search.danawa.com/dsearch.php?query={keyword}&page={page}"

        driver.get(main_url)

        soup = BeautifulSoup(driver.page_source, 'html.parser')

        links = soup.select('a.click_log_product_standard_title_')

        for link in links:
            data_dict = {}
            sub_url = link['href']
            driver.get(sub_url)

            soup = BeautifulSoup(driver.page_source, 'html.parser')

            # 상품 이름
            try:
                prod_name = soup.select_one(
                    "span.title").get_text(strip=True)
                print("[", rank,  "]", "prod_name : ", prod_name)
            except:
                prod_name = ""

            # 사료 이미지
            try:
                image_url = "https:" + \
                    soup.select_one("img#baseImage")['src']
            except:
                image_url = ""

            # 상품 가격
            try:
                product_min_price = soup.select_one(
                    "em.prc_c").text.replace(",", "")
            except:
                product_min_price = 0

            # 영양성분
            try:
                items_info = soup.select_one(
                    "div.items").get_text(strip=True)
                _, nutritional_info = items_info.split("[영양성분]")
                nutritional_protein, nutritional_fat = map(
                    str.strip, nutritional_info.split(" / "))

                nutritional_info = {
                    "조단백": nutritional_protein.split(":")[1].strip(),
                    "조지방": nutritional_fat.split(":")[1].strip()
                }
            except:
                nutritional_info = {}

            data_dict.update({"상품이름": prod_name,
                              "사료이미지": image_url,
                              "상품주소": sub_url,
                              "상품가격": product_min_price,
                              "영양성분": nutritional_info,
                              "순위": rank
                              })

            # 원료, 기능 성분, 특징, 인증 등
            spec_table = soup.find("table", class_="spec_tbl")

            if not spec_table:
                print("table not found")
            else:
                current_key = ""

                for row in spec_table.find_all('tr'):
                    ths = row.find_all('th')
                    tds = row.find_all('td')

                    for idx, th in enumerate(ths):

                        if len(tds) == 0:
                            current_key = ths[idx].text.strip()
                            data_dict[current_key] = []
                        else:
                            if current_key == "":
                                if ths[idx].text == "":
                                    pass
                                else:
                                    data_dict[ths[idx].text] = tds[idx].text.split(" ")[
                                        0].strip()
                            else:
                                if ths[idx].text == "":
                                    pass
                                else:
                                    data_dict[current_key].append(
                                        ths[idx].text.strip())

            collection.insert_one(data_dict)  # mongo db save

            rank += 1
            if (rank > 100):
                done = True
                break

    client.close()
    driver.close()
