package com.example.demo.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
@Primary
public class JsonServiceRandomizer implements JsonService {
    private final List<JsonService> services;
    private final Random random = new Random();

    public JsonServiceRandomizer(List<JsonService> services) {
        this.services = services;
    }

    @Override
    public String toJson(Map<String, Object> data) {
        int index = random.nextInt(services.size());
        JsonService selectedService = services.get(index);
        return selectedService.toJson(data);
    }
}
