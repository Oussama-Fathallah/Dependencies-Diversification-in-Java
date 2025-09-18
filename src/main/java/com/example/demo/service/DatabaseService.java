package com.example.demo.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DatabaseService {

    private final JdbcTemplate jdbc;
    private final SqlRandService sqlRand;

    public DatabaseService(JdbcTemplate jdbc, SqlRandService sqlRand) {
        this.jdbc = jdbc;
        this.sqlRand = sqlRand;
        // Crée la table
        jdbc.execute("CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY, name VARCHAR(100))");
        // Insert initial avec MERGE pour H2
        jdbc.update("MERGE INTO users (id, name) KEY(id) VALUES (1, 'Alice')");
        jdbc.update("MERGE INTO users (id, name) KEY(id) VALUES (2, 'Bob')");
    }

    public List<Map<String, Object>> queryUsers() {
        String sql = "SELECT * FROM users WHERE id > 0";
        String randomized = sqlRand.randomizeQuery(sql);
        String validated = sqlRand.validateQuery(randomized);
        return jdbc.queryForList(validated);
    }
}
