package org.cnspark.test;

import org.junit.Test;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;

/**
 * LogBack��־ϵͳ����־���� TRACE < DEBUG < INFO < WARN < ERROR.
 * 
 * @author milo
 * 
 */
public class HelloWorld2 {

	@Test
	public void levelTest() {
		ch.qos.logback.classic.Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("com.foo");

		// ������־���������
		logger.setLevel(Level.INFO);
		// ������� warn >= info
		logger.warn("low fuel level");
		// ������� warn >= error
		logger.error("error");

		// ����һ����Logger.�����ǵ���������
		// com.foo�Ǹ�
		// com.foo.bar����
		// �ӻ�̳и�����־ϵͳ����
		ch.qos.logback.classic.Logger barLogger = (ch.qos.logback.classic.Logger) LoggerFactory .getLogger("com.foo.bar");
		// ������info ,�������,�������
		barLogger.info("barlogger++++++++");
		// ������info,debug < info
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
