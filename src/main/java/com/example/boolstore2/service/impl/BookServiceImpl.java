package com.example.boolstore2.service.impl;

import com.example.bookstore.entity.Book;
import com.example.boolstore2.repository.BookRepository;
import com.example.boolstore2.service.BookService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    @PersistenceContext
    private EntityManager em;

    private final BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        try {
            if (book.getId() == null) {
                em.persist(book);
                return book;
            } else {
                return em.merge(book);
            }
        } catch (Exception e) {
            throw new RuntimeException("Can't save book with title: " + book.getTitle(), e);
        }
    }

    @Override
    public List<Book> findAll() {
        try {
            return em.createQuery("select b from Book b", Book.class).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Can't fetch books from DB", e);
        }
    }
}
