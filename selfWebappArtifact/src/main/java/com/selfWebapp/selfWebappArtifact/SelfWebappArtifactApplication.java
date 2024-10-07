package com.selfWebapp.selfWebappArtifact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.EnableKafka;


@SpringBootApplication
@ComponentScan(basePackages = {"com.selfWebapp.selfWebappArtifact"})
public class SelfWebappArtifactApplication {

	public static void main(String[] args) {
		SpringApplication.run(SelfWebappArtifactApplication.class, args);
	}

}
