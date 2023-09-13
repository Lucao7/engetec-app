package br.edu.fateczl.engetec.maven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = {"controller","service","model", "repository"})

public class App {
    
    public static void main(String[] args) {
    	SpringApplication.run(App.class, args);
    }
    
}
