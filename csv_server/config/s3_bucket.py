import boto3
from .settings import ACCESS_KEY, SECRET_KEY

s3 = boto3.client(
    "s3",
    aws_access_key_id=ACCESS_KEY,
    aws_secret_access_key=SECRET_KEY
)
