package io.test.properties;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest
class SystemSetPropsTest {

	@BeforeAll
	static void setProperties() {
		System.setProperty("spring.application.name", "new-name");
		System.setProperty("server.port", "8099");
	}

	@AfterAll
	static void clearProperties() {
		System.setProperty("spring.application.name", "properties");
		System.clearProperty("server.port");
	}

	@Autowired
	private Environment env;

	@Test
	void test() {
		Assertions.assertEquals("new-name", env.getProperty("spring.application.name"));
		Assertions.assertEquals(false, env.getProperty("spring.jpa.open-in-view", Boolean.class));
		Assertions.assertEquals(8099, env.getProperty("server.port", Integer.class));
	}

}
