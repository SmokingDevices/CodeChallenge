package de.pacesys.codechallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class CodeChallengeServer {

    public static void main(String[] args) {
        SpringApplication.run(CodeChallengeServer.class, args);
    }
}
