FROM python:3.9-slim

WORKDIR /app

ENV PYTHONDONTWRITEBYTECODE 1
ENV PYTHONBUFFERED 1

COPY ./crawling_server/woo_young_soo/ .

RUN pip install --no-cache-dir -r requirements.txt

COPY ./crawling_server/woo_young_soo ./app
