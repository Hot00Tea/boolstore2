package com.example.boolstore2;

import com.example.bookstore.entity.Book;
import com.example.boolstore2.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class Boolstore2Application {
	public static void main(String[] args) {
		SpringApplication.run(Boolstore2Application.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(BookService bookService) {
		return args -> {
			// Пример записи для проверки
			bookService.save(new Book("Clean Code", "Robert C. Martin", "9780132350884",
					new BigDecimal("35.50"), "Classic book about writing clean code", null));
			System.out.println("Books in DB:");
			bookService.findAll().forEach(System.out::println);
		};
	}
}
