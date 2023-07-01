from fastapi import APIRouter, Depends
from sqlalchemy.orm import Session


from database import SessionLocal, engine
from schemas import bloodsugar_schema
from services import bloodsugar_svc

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


@router.post("/csv/")
def upload_csv(file_upload: bloodsugar_schema.FileUpload, db: Session = Depends(get_db)):
    file_path = file_upload.file_path
    bloodsugar_svc.save_data(file_path, db)
    return {"message": "CSV data saved successfully!"}
