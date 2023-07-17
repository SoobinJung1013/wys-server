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
|DATABASE_HOST|db host for spring data jpa server|
|DATABASE_PORT|db port for spring data jpa server|
|DATABASE_NAME|db name for spring data jpa server|
|DATABASE_USERNAME|db username for spring data jpa server|
|DATABASE_PASSWORD|db password for spring data jpa server|
|AWS_ACCESS_KEY_ID|access key for s3 bucket|
|AWS_SECRET_ACCESS_KEY|secret key for s3 bucket|
|AWS_BUCKET_NAME|bucket name of s3|


#### crawling server .env
|NAME|VAlUE|
|---|:---|
|MONGO_ADMIN|db name for spring server|
|MONGO_PASSWORD|db username for spring server|
|MONGO_HOST|db password for spring server|
|MONGO_PORT|db username for spring server|
|MONGO_DATABASE|db password for spring server|


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
