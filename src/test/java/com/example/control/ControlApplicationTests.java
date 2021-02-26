package com.example.control;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class ControlApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("taras");
        System.out.println(new BCryptPasswordEncoder().encode("taras"));
        System.out.println("dima");
        System.out.println(new BCryptPasswordEncoder().encode("dima"));
    }

}
