package com.arch.sprint8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Sprint8Application {

	public static void main(String[] args) {
		SpringApplication.run(Sprint8Application.class, args);
	}

	@GetMapping("/reports")
	@ResponseStatus(HttpStatus.OK)
	String getReports(@AuthenticationPrincipal Jwt jwt) {
		System.out.println("JWT claims: " + jwt.getClaims());
		return "Report for " + jwt.getClaims().get("email");
	}
}
