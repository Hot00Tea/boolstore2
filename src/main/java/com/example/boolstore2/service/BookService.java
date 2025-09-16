package com.example.boolstore2.service;

import com.example.bookstore.entity.Book;
import java.util.List;

public interface BookService {
    Book save(Book book);
    List<Book> findAll();
}