package br.com.alura.listavip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.alura.enviadorEmail.EmailService;

@SpringBootApplication
public class Configuracao {
	public static void main(String[] args) {
		SpringApplication.run(Configuracao.class, args);
	}
	/*
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/listavip");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		return dataSource;
	}*/
	
	@Bean
	public EmailService emailService() {
		return new EmailService();
	}
}
