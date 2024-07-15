package io.test.properties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

@SpringBootTest
class DynamicPropertySourceTest {

	@Autowired
	private Environment env;

	@DynamicPropertySource
	static void properties(DynamicPropertyRegistry registry) {
		registry.add("spring.application.name", () -> "new-name");
		registry.add("server.port", () -> 8099);
	}

	@Test
	void test() {
		Assertions.assertEquals("new-name", env.getProperty("spring.application.name"));
		Assertions.assertEquals(false, env.getProperty("spring.jpa.open-in-view", Boolean.class));
		Assertions.assertEquals(8099, env.getProperty("server.port", Integer.class));
	}
}
