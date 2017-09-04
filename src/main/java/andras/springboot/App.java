package com.andrastoth.mavenfirsttry;

import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Bean
	CommandLineRunner runner (BirdRepository br) {
		return args -> {
				Arrays.asList("Madar1,Madar2,Madar3, Madar4, Madar5".split(","))
					.forEach(n->br.save(new Bird(n)));
				
				br.findAll().forEach (System.out::println);
				br.findByBirdName("Madar1").forEach (System.out::println);
				br.findByBirdSize("default").forEach (System.out::println);
		};
	}
}



