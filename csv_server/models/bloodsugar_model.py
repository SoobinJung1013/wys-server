from sqlalchemy import Column, Integer, String, DateTime
from database import Base


class BloodSugar(Base):
    __tablename__ = "blood_sugar"

    id = Column(Integer, primary_key=True, autoincrement=True)
    device = Column(String(45), nullable=False)
    serial_number = Column(String(45), nullable=False)
    timestamp = Column(DateTime, nullable=False)
    device_type = Column(Integer, nullable=False)
    past_blood_sugar = Column(Integer)
    scan_blood_sugar = Column(Integer)

    def __repr__(self):
        return f"<BloodSugar(id={self.id}, device={self.device}, serial_number={self.serial_number})>"
