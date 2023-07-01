from pydantic import BaseModel


class FileUpload(BaseModel):
    file_path: str


class DataIn(BaseModel):
    device: str
    serial_number: str
    timestamp: str
    device_type: int
    past_blood_sugar: int
    scan_blood_sugar: int


class DataOut(BaseModel):
    device: str
    timestamp: str
    device_type: int
    past_blood_sugar: int
    scan_blood_sugar: int
