package com.example.demo.controller;

import com.example.demo.service.DatabaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SqlController {

    private final DatabaseService db;

    public SqlController(DatabaseService db) {
        this.db = db;
    }

    @GetMapping("/sql/test")
    public Object testSql() {
        return db.queryUsers();
    }
}
