package com.zaurtregulov.spring.springboot.springboot_rest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SpringbootRestApplicationTests {

	@Test
	void contextLoads() {
		int i=1;
		assertEquals(1, i);
	}

}
