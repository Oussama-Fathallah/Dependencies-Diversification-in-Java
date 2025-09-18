package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SqlRandService {

    private final String salt;

    public SqlRandService() {
        this.salt = "_" + new Random().nextInt(1000);
    }

    public String randomizeQuery(String query) {
        return query.replaceAll("\\bSELECT\\b", "SELECT" + salt)
                .replaceAll("\\bFROM\\b", "FROM" + salt)
                .replaceAll("\\bWHERE\\b", "WHERE" + salt);
    }

    public String validateQuery(String query) {
        return query.replace(salt, "");
    }

    public String getSalt() { return salt; }
}
