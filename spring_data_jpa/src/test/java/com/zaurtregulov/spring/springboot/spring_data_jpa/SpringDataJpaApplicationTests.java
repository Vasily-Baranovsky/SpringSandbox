package com.zaurtregulov.spring.springboot.spring_data_jpa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SpringDataJpaApplicationTests {

	@Test
	void contextLoads() {
		int i=2;
		assertEquals(1,i);
	}

}
