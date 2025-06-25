package com.example.springboot; //springboot CANNOT be spring_boot

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Application.class) //need this to run tests for some reason
class ApplicationTests {

	@Test
	void contextLoads() {
	}

}
