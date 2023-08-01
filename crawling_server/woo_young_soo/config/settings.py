from dotenv import load_dotenv
import os

# Load environment variables from .env file
load_dotenv()

# Retrieve the values from the environment variables
MONGO_ADMIN = os.getenv("MONGO_ADMIN")
MONGO_PASSWORD = os.getenv("MONGO_PASSWORD")
MONGO_DATABASE = os.getenv("MONGO_DATABASE")
MONGO_HOST = os.getenv("MONGO_HOST")
MONGO_PORT = os.getenv("MONGO_PORT")
