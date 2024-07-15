package io.test.properties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

//rename src/test/resources/config/_application.properties to src/test/resources/config/application.properties
@SpringBootTest
class ConfigDirTest {

	@Autowired
	private Environment env;

	@Test
	void test() {
		Assertions.assertEquals("new-name", env.getProperty("spring.application.name"));
		Assertions.assertEquals(false, env.getProperty("spring.jpa.open-in-view", Boolean.class));
		Assertions.assertEquals(8099, env.getProperty("server.port", Integer.class));
	}

}
