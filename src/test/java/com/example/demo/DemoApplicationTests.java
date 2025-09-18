package com.example.demo;

import com.example.demo.service.JsonService;
import com.example.demo.service.DatabaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.SqlRandService;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private JsonService jsonService;

    @Autowired
    private DatabaseService databaseService; // vraie instance

    @Autowired
    private SqlRandService sqlRand; // injection de SQLRand

    @Test
    void contextLoads() {
        // Vérifie juste que le contexte se charge
    }

    @Test
    void jsonServiceProducesJson() {
        String json = jsonService.toJson(Map.of("k", "v", "n", 123));
        assertTrue(json.contains("\"k\""), "JSON should contain key 'k'");
    }

    @Test
    void databaseServiceQueryUsersWorks() {
        var users = databaseService.queryUsers();
        assertTrue(users.size() >= 2, "Should have at least 2 users");
        assertTrue(users.stream().anyMatch(u -> "Alice".equals(u.get("name"))));
        assertTrue(users.stream().anyMatch(u -> "Bob".equals(u.get("name"))));
    }

    @Test
    void sqlRandRandomizesAndValidatesQuery() {
        String original = "SELECT * FROM users WHERE id > 0";

        // Randomisation
        String randomized = sqlRand.randomizeQuery(original);
        System.out.println("Randomized SQL: " + randomized);
        assertNotEquals(original, randomized, "La requête doit être randomisée");

        // Validation
        String validated = sqlRand.validateQuery(randomized);
        System.out.println("Validated SQL: " + validated);
        assertEquals(original, validated, "La requête doit redevenir normale après validation");
    }
}
