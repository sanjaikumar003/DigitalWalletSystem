package com.sanjai.digitalwalletsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class DigitalWalletSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalWalletSystemApplication.class, args);
	}

}
