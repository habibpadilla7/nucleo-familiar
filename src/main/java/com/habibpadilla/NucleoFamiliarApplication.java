package com.habibpadilla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class NucleoFamiliarApplication {

	public static void main(String[] args) {
		SpringApplication.run(NucleoFamiliarApplication.class, args);
	}

}
