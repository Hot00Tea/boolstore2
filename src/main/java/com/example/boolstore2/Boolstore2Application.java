package com.example.boolstore2;

import com.example.boolstore2.entity.Book;
import com.example.boolstore2.service.BookService;
import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Boolstore2Application {
    public static void main(String[] args) {
        SpringApplication.run(Boolstore2Application.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(BookService bookService) {
        return args -> {
            Book book = new Book();
            book.setTitle("Clean Code");
            book.setAuthor("Robert C. Martin");
            book.setIsbn("9780132350884");
            book.setPrice(new BigDecimal("35.50"));
            book.setDescription("Classic book about writing clean code");

            bookService.save(book);

            System.out.println("Books in DB:");
            bookService.findAll().forEach(System.out::println);
        };
    }
}
