package com.example.boolstore2.repository;

import com.example.bookstore.entity.Book;
import java.util.List;

public interface BookRepository {
    Book save(Book book);
    List<Book> findAll();
}
