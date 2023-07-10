from botocore.exceptions import ClientError
import csv
from fastapi import APIRouter,  UploadFile
from sqlalchemy.orm import Session

from config.s3 import s3

from database import SessionLocal, engine
from schemas import bloodsugar_schema
from services import bloodsugar_svc
from config.settings import BUCKIT_NAME

router = APIRouter()

# Dependency


def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()


@router.get("/csv/")
def read_items(skip: int = 0, limit: int = 100, db: Session = Depends(get_db)):
    datas = bloodsugar_svc.get_data(db, skip=skip, limit=limit)
    return datas


@router.post("/upload/")
async def upload_csv_to_s3(file: UploadFile = File(...)):

    # Upload file to S3 bucket
    s3.upload_fileobj(file.file, BUCKIT_NAME, file.filename)
    file_url = f"https://{BUCKIT_NAME}.s3.amazonaws.com/{file.filename}"
    print("file url :", file_url)

    # Call upload_csv with the file URL instead of the file object
    response = upload_csv_to_rdb(file_url)
    print("upload to mysql message: ", response)

    return {"message": "File uploaded successfully"}


def upload_csv_to_rdb(file_url: str, db: Session = next(get_db())):
    object_key = file_url.split('/')[-1]

    try:
        # Get the file data from S3
        response = s3.get_object(Bucket=BUCKIT_NAME, Key=object_key)
        data = response['Body'].read().decode('utf-8')

        # Process the CSV data
        reader = csv.reader(data.splitlines())
        lines = list(reader)

        bloodsugar_svc.save_data(lines, db)
        return {"message": "CSV data saved successfully!"}
    except ClientError as e:
        print(f"Error getting file from S3: {e}")
        return {"message": "Failed to retrieve file from S3"}
