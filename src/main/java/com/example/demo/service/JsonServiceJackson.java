package com.example.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class JsonServiceJackson implements JsonService {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String toJson(Map<String, Object> data) {
        try {
            return mapper.writeValueAsString(data);
        } catch (Exception e) {
            return "{\"error\":\"" + e.getMessage() + "\"}";
        }
    }
}
