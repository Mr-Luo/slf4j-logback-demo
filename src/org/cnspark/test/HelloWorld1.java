package org.cnspark.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

/**
 * 用于学习使用logback
 * @author milo
 *
 */
public class HelloWorld1 {
	
	@Test
	public void test(){
		Logger logger = LoggerFactory.getLogger(HelloWorld1.class);
		logger.debug("hello world1");
		
	}
	
	@Test
	public void test2(){
		Logger logger = LoggerFactory.getLogger(HelloWorld1.class);
		logger.debug("hello world2");
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
	    StatusPrinter.print(lc);
	}
}
