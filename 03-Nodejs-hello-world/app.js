import express from 'express';
import dotenv from 'dotenv';
import { join, dirname } from 'path';
import { fileURLToPath } from 'url';

dotenv.config();

const app = express();
const PORT = process.env.PORT || 8080;
const IMAGE_URL = '/images/noventiq-vp.png';

// For __dirname in ES module
const __filename = fileURLToPath(import.meta.url);
const __dirname = dirname(__filename);

// Serve static files from "public" folder
app.use(express.static(join(__dirname, 'public')));

// app.get('/', (req, res) => {
//   res.send('Hello, World!,  Check with endpoint /noventiq-vp-hello');
// });

app.get('/', (req, res) => {
  const appTitle = process.env.APP_TITLE || 'My App';
  const html = `
    <html>
      <head><title>Image Viewer</title></head>
      <body>
        <h1>${appTitle}</h1>
        <h2>App modernization</h2>
        <img src="${IMAGE_URL}" alt="Image" width="500"/>
      </body>
    </html>
  `;
  res.send(html);
});

app.listen(PORT, () => {
  console.log(`Server running at http://localhost:${PORT}`);
});
