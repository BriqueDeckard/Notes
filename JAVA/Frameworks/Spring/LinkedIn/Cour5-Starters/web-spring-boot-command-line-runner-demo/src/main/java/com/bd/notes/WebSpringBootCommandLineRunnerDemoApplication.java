package com.bd.notes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebSpringBootCommandLineRunnerDemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(DemoCommandLineRunner1.class);

	public static void main(String[] args) {
		logger.info("==== Debut execution main ====");
		SpringApplication.run(WebSpringBootCommandLineRunnerDemoApplication.class, args);
		logger.info("==== Fin execution main ====");
	}

}
