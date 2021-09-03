package com.example.springbootkaratedemo.karate;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookApiTest {

    @LocalServerPort
    private int port;

    @Test
    void karateTests() {
        System.setProperty("local.server.port", String.valueOf(port));
        Results results = Runner.path("classpath:features").tags("book").parallel(2);
        assertThat(results.getFailCount()).isEqualTo(0);
    }
}
