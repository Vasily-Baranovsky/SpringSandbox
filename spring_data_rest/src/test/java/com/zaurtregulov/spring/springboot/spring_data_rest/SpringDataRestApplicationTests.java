package com.zaurtregulov.spring.springboot.spring_data_rest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringDataRestApplicationTests {

    @Test
    void contextLoads() {
        int i=2;
        Assertions.assertEquals(2,i);
    }

}
