package com.example.demo.controller;

import com.example.demo.service.JsonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class JsonController {

    private final JsonService jsonService;

    public JsonController(JsonService jsonService) {
        this.jsonService = jsonService;
    }

    @GetMapping("/json/test")
    public String testJson() {
        Map<String,Object> data = Map.of(
                "library", jsonService.getClass().getSimpleName(),
                "message","Hello from diversified JSON service!",
                "timestamp", System.currentTimeMillis()
        );
        return jsonService.toJson(data);
    }
}
