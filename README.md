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


### 2️⃣ docker compose build and up

```shell
cd bloodsugar_server
./gradlew clean build -x test

```

<br />


```shell
cd ../
docker-compose up --build 
# or
docker-compose up --build -d
```

<br />

```shell
docker-compose down
# or 
docker-compose down -v ## delete volumn
```
