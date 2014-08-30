package org.cnspark.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloSlf4J {
	@Test
	public void testA() {

		Logger logger = LoggerFactory.getLogger(HelloSlf4J.class);
		logger.info("Hello World");

	}
	@Test
	public void testB() {
		final Logger logger = LoggerFactory.getLogger(HelloSlf4J.class);

		logger.warn("Temperature set to {}. Old temperature was {}.", 20, 30);

	}
}
