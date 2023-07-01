from dotenv import load_dotenv
import os

load_dotenv()

# MySQL Database Configuration
DATABASE_HOST = os.getenv("MYSQL_HOST", "localhost")
DATABASE_PORT = int(os.getenv("MYSQL_PORT", "3306"))
DATABASE_USER = os.getenv("MYSQL_USER", "root")
DATABASE_PASSWORD = os.getenv("MYSQL_PASSWORD", "")
DATABASE_NAME = os.getenv("MYSQL_DATABASE", "my_database")
DATABASE_PORT = int(os.getenv("MYSQL_PORT", "3306"))
