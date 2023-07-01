# poc server test

## How to Run ? 
### 1️⃣ set .env  

|NAME|VAlUE|
|---|:---|
|MYSQL_HOST|mysql host name for python server|
|MYSQL_DATABAS|mysql database name|
|MYSQL_USER|mysql user name|
|MYSQL_PASSWORD|mysql user password|
|MYSQL_ROOT_PASSWORD|mysqlroot password|
|DATABASE_HOST|db host for spring server|
|DATABASE_PORT|db port for spring server|
|DATABASE_NAME|db name for spring server|
|DATABASE_USERNAME|db username for spring server|
|DATABASE_PASSWORD|db password for spring server|


### 2️⃣ docker compose build and up

```shell
cd bloodsugar_server
./gradlew clean build -x test

```

<br />


```shell
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