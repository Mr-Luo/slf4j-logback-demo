package org.cnspark.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;


/**
 * LogBack会按以下顺序在classpath中查找以下配置文件或类,进行加载.找到就停止,没有找到就继续,直至到第4个
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
		//classpath中没有上述前三个配置文件,因此使用了BasicConfigurator
		//默认的格式	%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n.
		
		/*********************没有添加配置文件的输出结果****************************/
		//11:04:29.788 [main] INFO  org.cnspark.test.HelloWorld3 - Entering application.
		//11:04:29.795 [main] DEBUG org.cnspark.test.HelloWorld3$Foo - Did it again!
		//11:04:29.795 [main] INFO  org.cnspark.test.HelloWorld3 - Exiting application.

		/**********************添加配置文件的输出结果*******************************************/
		//11:06:47 [main] INFO  org.cnspark.test.HelloWorld3 - Entering application.
		//11:06:48 [main] DEBUG org.cnspark.test.HelloWorld3$Foo - Did it again!
		//11:06:48 [main] INFO  org.cnspark.test.HelloWorld3 - Exiting application.
		
		//把logback.xml中Pattern元素配置成
		//<pattern>%d{HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n</pattern>
		//对比%d{HH:mm:ss}和%d{HH:mm:ss.SSS}以及输出结果可以看出配置文件生效了.
		
		//如果想效果明显点.
		//可以把<root level="debug">修改成<root level="info">再运行
		/****************修改输出日志级别后的输出结果******************************/
		//11:12:37 [main] INFO  org.cnspark.test.HelloWorld3 - Entering application.
		//11:12:37 [main] INFO  org.cnspark.test.HelloWorld3 - Exiting application.
		

		
		/**
		 * 可以通过两种方式输出启动信息
		 * <ul>
		 * 	<li>1 在java代码中调用</li>
		 * 	<li>2 在配置文件中配置</li>
		 * </ul>
		 * ***/
		
		//方式一:
		 // assume SLF4J is bound to logback in the current environment
		 //	LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
	     // print logback's internal status
	     // StatusPrinter.print(lc);
		
		
		//方式二:
		//<configuration debug="true"> 上配置debug属性
		
		
		/**打印出详细 启动信息*/
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
