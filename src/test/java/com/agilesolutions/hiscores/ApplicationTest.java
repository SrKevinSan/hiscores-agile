package com.agilesolutions.hiscores;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ApplicationTest {
    @Test
    public void testNotFound() throws Exception {
        TestRestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(
                new URL("http://localhost:" + "8081" + "/category/notFound").toString(), String.class);
        assertEquals("Resource not found", response.getBody());

    }
}
