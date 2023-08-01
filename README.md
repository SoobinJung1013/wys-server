# poc server test

## How to Run ? 
### 1️⃣ set .env  

#### root .env
|NAME|VAlUE|
|---|:---|
|MYSQL_HOST|mysql host name|
|MYSQL_DATABASE|mysql database name|
|MYSQL_USER|mysql user name|
|MYSQL_PASSWORD|mysql user password|
|MYSQL_ROOT_PASSWORD|mysqlroot password|
|DATABASE_HOST|db host for spring server|
|DATABASE_PORT|db port for spring server|
|DATABASE_NAME|db name for spring server|
|DATABASE_USERNAME|db username for spring server|
|DATABASE_PASSWORD|db password for spring server|
|AWS_ACCESS_KEY_ID|access key for s3 bucket|
|AWS_SECRET_ACCESS_KEY|secret key for s3 bucket|
|AWS_BUCKET_NAME|bucket name of s3|
|MONGO_USERNAME|mongo user for spring server|
|MONGO_PASSWORD|mongo password for spring server|
|MONGO_HOST|mongo host for spring server|
|MONGO_PORT|mongo port for spring server|
|MONGO_DATABASE|mongo database for spring server|


#### crawling server .env
|NAME|VAlUE|
|---|:---|
|MONGO_ADMIN|mongo user for crawling server|
|MONGO_PASSWORD|mongo password for crawling server|
|MONGO_HOST|mongo host for crawling server|
|MONGO_PORT|mongo port for crawling server|
|MONGO_DATABASE|mongo database for crawling server|

#### elk stack version
|NAME|VAlUE|
|---|:---|
|ELK_VERSION|elk stack version|


### 2️⃣ docker compose build and up

```shell
cd api_server
./gradlew clean build -x test

```

<br />

> local
```shell
cd ../
docker-compose up --build 
# or
docker-compose up --build -d
```

> prod
```shell
# m1이면 cadvisor image 변경해주어야 한다. 
docker compose -f docker-compose.prod.yml -f docker-compose.logging.yml up
```

### 3️⃣ docker compose down

<br />

> local
```shell
docker-compose down
# or 
docker-compose down -v ## delete volumn
```

> prod
```shell
docker-compose -f docker-compose.prod.yml -f docker-compose.logging.yml down
```

<br />

## Run Crawlig Server

```shell
cd crawling_server/woo_young_soo
python3 manage.py runserver --noreload 
```

<br />

## Load Test Command

spring server
```shell
k6 run simple_load_test.js
```