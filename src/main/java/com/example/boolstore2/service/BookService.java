package com.example.boolstore2.service;

import com.example.boolstore2.entity.Book;
import java.util.List;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();
}
