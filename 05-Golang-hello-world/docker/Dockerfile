# Stage 1: Build
FROM golang:1.24 AS builder

WORKDIR /app


# Copy all source files
COPY . ./

# Copy go.mod first
COPY go.mod ./

RUN go mod download

RUN go build -o hello-world-go main.go

# Stage 2: Runtime
FROM debian:stable-slim

WORKDIR /app

COPY --from=builder /app/hello-world-go .

EXPOSE 8080

CMD ["./hello-world-go"]
