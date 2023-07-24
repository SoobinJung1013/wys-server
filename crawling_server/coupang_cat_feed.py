import requests
from bs4 import BeautifulSoup
from pymongo import MongoClient
from config import MONGO_ADMIN, MONGO_PASSWORD, MONGO_HOST, MONGO_PORT, MONGO_DATABASE

# Mongo DB Ceonnection
client = MongoClient(
    f"mongodb://{MONGO_ADMIN}:{MONGO_PASSWORD}@{MONGO_HOST}:{MONGO_PORT}")
db = client[MONGO_DATABASE]
collection = db["cat_feed"]

keyword = "고양이 사료"

rank = 1
done = False

for page in range(1, 6):
    if done == True:
        break
    print(page, "번째 페이지 입니다. ")
    main_url = f"https://search.danawa.com/dsearch.php?query={keyword}&page={page}"

    header = {
        'Host': 'https://danawa.com/',
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:76.0) Gecko/20100101 Firefox/76.0',
        'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8',
        'Accept-Language': 'ko-KR,ko;q=0.8,en-US;q=0.5,en;q=0.3',
    }

    response = requests.get(main_url, headers=header)
    html = response.text
    soup = BeautifulSoup(html, 'html.parser')

    links = soup.select("a.search-product-link")

    for link in links:
        data = {}
        if len(link.select("span.ad-badge-text")) > 0:
            print("광고상품입니다. ")
        else:
            sub_url = "https://www.coupang.com" + link.attrs['href']

            response = requests.get(sub_url, headers=header)
            html = response.text
            soup = BeautifulSoup(html, 'html.parser')

            # 브랜드 이름
            try:
                brand_name = soup.select_one(
                    "a.prod-brand-name").get_text(strip=True)
            except:
                brand_name = ""

            # 상품 이름
            try:
                product_name = soup.select_one(
                    "h2.prod-buy-header__title").get_text(strip=True)
            except:
                product_name = ""

            # 상품 가격
            try:
                product_price = soup.select_one(
                    "span.total-price > strong").text
            except:
                product_price = 0

            # 이미지 URL
            try:
                image_url = "https:" + \
                    soup.select_one("#repImageContainer > img")['src']
            except:
                image_url = ""

            data.update({
                "rank": rank,
                "brand_name": brand_name,
                "product_name": product_name,
                "product_price": product_price,
                "image_url": image_url,
                "sub_url": sub_url
            })

            # 상품 디테일
            try:
                attr_items = soup.select(
                    "div.prod-description > ul > li")

                for item in attr_items:
                    text = item.get_text(strip=True)

                    key = text.split(":")[0].strip()
                    value = text.split(":")[1].strip()

                    data.update({
                        key: value,
                    })
            except:
                pass

            collection.insert_one(data)

            rank += 1
            if (rank > 100):
                done = True
                break

client.close()
