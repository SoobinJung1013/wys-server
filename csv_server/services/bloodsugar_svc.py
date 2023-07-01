import csv
from sqlalchemy.orm import Session

from models.bloodsugar_model import BloodSugar


def get_data(db: Session, skip: int = 0, limit: int = 100):
    return db.query(BloodSugar).offset(skip).limit(limit).all()


def save_data(file_path: str, db: Session):
    with open(file_path, 'r', encoding='utf-8') as f:
        reader = csv.reader(f)
        lines = list(reader)

    for line in lines[3:]:
        device = line[0]
        serial_number = line[1]
        timestamp = line[2]
        device_type = int(line[3])
        past_blood_sugar = convert_to_int(line[4])
        scan_blood_sugar = convert_to_int(line[5])

        blood_sugar = BloodSugar(
            device=device,
            serial_number=serial_number,
            timestamp=timestamp,
            device_type=device_type,
            past_blood_sugar=past_blood_sugar,
            scan_blood_sugar=scan_blood_sugar
        )

        db.add(blood_sugar)

    db.commit()


def convert_to_int(value):
    if value is None:
        return 0
    else:
        try:
            return int(value)
        except ValueError:
            return 0
