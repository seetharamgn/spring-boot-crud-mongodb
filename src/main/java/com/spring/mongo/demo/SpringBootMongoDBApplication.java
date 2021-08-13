package com.spring.mongo.demo;

import com.spring.mongo.demo.model.Customer;
import com.spring.mongo.demo.repository.CustomerRepository;
import com.spring.mongo.demo.utils.HelperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;


@SpringBootApplication
@EnableMongoRepositories
public class SpringBootMongoDBApplication {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongoDBApplication.class, args);
	}




	@Autowired
	private CustomerRepository superHeroRepository;

	
	@Bean
	CommandLineRunner runner() {
		return args -> {


			List<Customer> superHeroes = superHeroRepository.findAll();
			if (superHeroes.size() == 0) {
				LOGGER.info("******* Inserting Super heroes to DB *******");
				superHeroRepository.saveAll(HelperUtil.superHeroesSupplier.get());
			} else {
				LOGGER.info("******* Super heroes stored in DB Size :: {}", superHeroes.size());
				LOGGER.info("******* Super heroes stored in DB :: {}", superHeroes);
			}
		};
	}

}
