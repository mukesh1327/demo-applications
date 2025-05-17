from fastapi import FastAPI
from fastapi.responses import HTMLResponse
from fastapi.staticfiles import StaticFiles
import os
from dotenv import load_dotenv

# Load environment variables from .env file
load_dotenv()

app = FastAPI()

app.mount("/images", StaticFiles(directory="images"), name="images")

# Define a static image path
IMAGE_URL = "/images/noventiq-vp.png"  # Make sure this path matches the actual file location

# Read APP_TITLE from system env or .env file (system env takes priority)
APP_TITLE = os.getenv("APP_TITLE", "Welcome pytohn py-uvicorn")

# @app.get("/")
# async def hello_world():
#     return {"message": "Hello, World! check with endpoint /noventiq-vp-hello"}

@app.get("/", response_class=HTMLResponse)
async def get_image_html():
    html_content = f"""
    <html>
        <head><title>Image Viewer</title></head>
        <body>
            <h1>{APP_TITLE}</h1>
            <h2>App modernization</h2>
            <img src='{IMAGE_URL}' alt='Image' width='500'/>
        </body>
    </html>
    """
    return HTMLResponse(content=html_content)

if __name__ == "__main__":
    import uvicorn
    uvicorn.run("main:app", host="0.0.0.0", port=8080, reload=True)
