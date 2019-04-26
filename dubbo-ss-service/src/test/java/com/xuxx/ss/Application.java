package com.xuxx.ss;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	private final static Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		context.start();
		logger.debug("==== service start ====");
		System.in.read();
		context.close();
	}
}
