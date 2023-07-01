FROM python:3.9-slim

WORKDIR /app

ENV PYTHONDONTWRITEBYTECODE 1
ENV PYTHONBUFFERED 1

COPY ./csv_server/requirements.txt .

RUN pip install --no-cache-dir -r requirements.txt

COPY ./csv_server ./app
