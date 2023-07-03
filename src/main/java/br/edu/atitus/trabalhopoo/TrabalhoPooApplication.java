package br.edu.atitus.trabalhopoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import javax.naming.AuthenticationException;

@SpringBootApplication()
public class TrabalhoPooApplication {

  public static void main(String[] args) {
    SpringApplication.run(TrabalhoPooApplication.class, args);
  }

}
