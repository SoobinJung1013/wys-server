from fastapi import Depends, FastAPI, Body
from sqlalchemy.orm import Session

from models import bloodsugar_model

from database import SessionLocal, engine
from routers import bloodsugar_router


bloodsugar_model.Base.metadata.create_all(bind=engine)


app = FastAPI()


@app.get("/")
def root():
    return {"message": "Welcome to the API!"}


app.include_router(bloodsugar_router.router)
