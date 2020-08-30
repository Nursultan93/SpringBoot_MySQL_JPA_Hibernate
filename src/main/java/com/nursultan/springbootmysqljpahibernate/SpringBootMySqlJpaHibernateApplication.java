package com.nursultan.springbootmysqljpahibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringBootMySqlJpaHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMySqlJpaHibernateApplication.class, args);
	}

}
