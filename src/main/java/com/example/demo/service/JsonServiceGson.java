package com.example.demo.service;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class JsonServiceGson implements JsonService {
    private final Gson gson = new Gson();

    @Override
    public String toJson(Map<String, Object> data) {
        return gson.toJson(data);
    }
}
