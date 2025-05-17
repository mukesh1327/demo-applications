# Use official Node.js LTS image
FROM docker.io/library/node:slim

# Set working directory
WORKDIR /app

# Copy package files and install dependencies
COPY package*.json ./
RUN npm install

# Copy rest of the app
COPY public public/
COPY app.js .

# Expose the app port
EXPOSE 8080

# Start the application
CMD ["node", "app.js"]
