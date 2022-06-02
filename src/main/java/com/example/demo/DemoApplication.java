package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	private void seedDataBase() {
		personRepository.deleteAll();

		// Save some persons
		personRepository.save(new Person("John", "Snow"));
		personRepository.save(new Person("Aria", "Stark"));
		personRepository.save(new Person("Tyrion", "Lannister"));

		// fetch all persons
		System.out.println("Persons found with findAll():");
		System.out.println("-------------------------------");
		for (Person person: personRepository.findAll()) {
			System.out.println(person);
		}

		// fetch all persons by lastName
		System.out.println("Persons found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(personRepository.findByLastName("Stark"));
	}

	@Override
	public void run(String... args) throws Exception {
		seedDataBase();
	}
}
