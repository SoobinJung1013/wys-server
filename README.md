# poc server test

## How to Run ? 
### 1️⃣ set .env  

|NAME|VAlUE|
|---|:---|
|MYSQL_HOST| mysql host name|
|MYSQL_DATABAS|database name|
|MYSQL_USER|user name|
|MYSQL_PASSWORD|user password|
|MYSQL_ROOT_PASSWORD|root password|
|DATABASE_URL|db url for spring server|
|DATABASE_USERNAME|db username for spring server|
|DATABASE_PASSWORD|db username for spring server|



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