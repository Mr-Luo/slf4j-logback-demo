package org.cnspark.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;


/**
 * LogBack�ᰴ����˳����classpath�в������������ļ�����,���м���.�ҵ���ֹͣ,û���ҵ��ͼ���,ֱ������4��
 * <ul>
 * 	<li>1 logback.groovy</li>
 * 	<li>2 logback-test.xml</li>
 * 	<li>3 logback.xml</li>
 * 	<li>4 BasicConfigurator</li>
 * </ul>
 * 
 * @author milo
 *
 */
public class HelloWorld3 {
	
	
	@Test
	public void test(){
		//classpath��û������ǰ���������ļ�,���ʹ����BasicConfigurator
		//Ĭ�ϵĸ�ʽ	%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n.
		
		/*********************û����������ļ���������****************************/
		//11:04:29.788 [main] INFO  org.cnspark.test.HelloWorld3 - Entering application.
		//11:04:29.795 [main] DEBUG org.cnspark.test.HelloWorld3$Foo - Did it again!
		//11:04:29.795 [main] INFO  org.cnspark.test.HelloWorld3 - Exiting application.

		/**********************��������ļ���������*******************************************/
		//11:06:47 [main] INFO  org.cnspark.test.HelloWorld3 - Entering application.
		//11:06:48 [main] DEBUG org.cnspark.test.HelloWorld3$Foo - Did it again!
		//11:06:48 [main] INFO  org.cnspark.test.HelloWorld3 - Exiting application.
		
		//��logback.xml��PatternԪ�����ó�
		//<pattern>%d{HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n</pattern>
		//�Ա�%d{HH:mm:ss}��%d{HH:mm:ss.SSS}�Լ����������Կ��������ļ���Ч��.
		
		//�����Ч�����Ե�.
		//���԰�<root level="debug">�޸ĳ�<root level="info">������
		/****************�޸������־������������******************************/
		//11:12:37 [main] INFO  org.cnspark.test.HelloWorld3 - Entering application.
		//11:12:37 [main] INFO  org.cnspark.test.HelloWorld3 - Exiting application.
		

		
		/**
		 * ����ͨ�����ַ�ʽ���������Ϣ
		 * <ul>
		 * 	<li>1 ��java�����е���</li>
		 * 	<li>2 �������ļ�������</li>
		 * </ul>
		 * ***/
		
		//��ʽһ:
		 // assume SLF4J is bound to logback in the current environment
		 //	LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
	     // print logback's internal status
	     // StatusPrinter.print(lc);
		
		
		//��ʽ��:
		//<configuration debug="true"> ������debug����
		
		
		/**��ӡ����ϸ ������Ϣ*/
		/**
		 *<p/>15:38:10,445 |-INFO in ch.qos.logback.classic.LoggerContext[default] - Could NOT find resource [logback.groovy]
		 *15:38:10,445 |-INFO in ch.qos.logback.classic.LoggerContext[default] - Found resource [logback-test.xml] at [file:/E:/Workspaces/MyEclipse9/Slf4jDemo/bin/logback-test.xml]
		 *15:38:10,617 |-INFO in ch.qos.logback.core.joran.action.AppenderAction - About to instantiate appender of type [ch.qos.logback.core.ConsoleAppender]
		 *15:38:10,622 |-INFO in ch.qos.logback.core.joran.action.AppenderAction - Naming appender as [STDOUT]
		 *15:38:10,657 |-INFO in ch.qos.logback.core.joran.action.NestedComplexPropertyIA - Assuming default type [ch.qos.logback.classic.encoder.PatternLayoutEncoder] for [encoder] property
		 *15:38:10,724 |-INFO in ch.qos.logback.classic.joran.action.RootLoggerAction - Setting level of ROOT logger to DEBUG
		 *15:38:10,724 |-INFO in ch.qos.logback.core.joran.action.AppenderRefAction - Attaching appender named [STDOUT] to Logger[ROOT]
		 *15:38:10,725 |-INFO in ch.qos.logback.classic.joran.action.ConfigurationAction - End of configuration.
		 *15:38:10,727 |-INFO in ch.qos.logback.classic.joran.JoranConfigurator@f4721c7 - Registering current configuration as safe fallback point
		 *</p> 
		 * 
		 * 
		 * 
		 * */

		Logger logger = LoggerFactory.getLogger(HelloWorld3.class);
		logger.info("Entering application.");

		Foo foo = new Foo();
		foo.doIt();
		logger.info("Exiting application.");

	}

	class Foo {
		final Logger logger = LoggerFactory.getLogger(Foo.class);

		public void doIt() {
			logger.debug("Did it again!");
		}
	}

}
