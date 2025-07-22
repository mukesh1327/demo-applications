package com.cloudxplorer13.springboottodo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {

    @Value("${app.title}")
    private String appTitle;

    @Value("${app.image}")
    private String welcomeImg;

    // private static final String IMAGE_URL = "/images/noventiq-vp.png"; // Serve a fixed image

    public String getImageUrl() {
        return welcomeImg;
    }

    // @GetMapping("/")
    // public String helloWorld() {
    //     return "Hello, World!  Check with endpoint /noventiq-vp-hello";
    // }

    @GetMapping("/")
    public String getImageHtml() {
        return "<html>" +
                "<head><title>Image Viewer</title></head>" +
                "<body>" +
                "<h1>" + appTitle + "</h1>" +
                "<h2>App modernization</h2>" +
                "<img src='" + welcomeImg + "' alt='Image' width='500'/>" +
                "</body>" +
                "</html>";
    }
}
