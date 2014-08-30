package org.cnspark.test;

import org.junit.Test;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;

/**
 * LogBack日志系统的日志级别 TRACE < DEBUG < INFO < WARN < ERROR.
 * 
 * @author milo
 * 
 */
public class HelloWorld2 {

	@Test
	public void levelTest() {
		ch.qos.logback.classic.Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("com.foo");

		// 设置日志的输出级别
		logger.setLevel(Level.INFO);
		// 可以输出 warn >= info
		logger.warn("low fuel level");
		// 可以输出 warn >= error
		logger.error("error");

		// 创建一个子Logger.由他们的名字区分
		// com.foo是父
		// com.foo.bar是子
		// 子会继承父的日志系统级别
		ch.qos.logback.classic.Logger barLogger = (ch.qos.logback.classic.Logger) LoggerFactory .getLogger("com.foo.bar");
		// 父的是info ,两者相等,可以输出
		barLogger.info("barlogger++++++++");
		// 父的是info,debug < info
		barLogger.debug("barloger----------");

		/**
		 * <p>
		 * 17:53:01.350 [main] WARN com.foo - low fuel level <br/>
		 * 17:53:01.356 [main] ERROR com.foo - error<br/> 
		 * 17:53:01.357 [main] INFO com.foo.bar - barlogger++++++++<br/>
		 * </p>
		 * 
		 * */

	}

}
