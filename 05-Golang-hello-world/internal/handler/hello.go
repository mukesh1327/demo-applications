package handler

import (
    "fmt"
    "net/http"
)

// HelloHandler writes Hello, World as HTTP response
func HelloHandler(w http.ResponseWriter, r *http.Request) {
    fmt.Fprintln(w, "Hello, World!")
}
