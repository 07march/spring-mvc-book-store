package by.bookstore.service;

import by.bookstore.entity.Book;

import java.math.BigDecimal;

public interface BookService {
  void add(Book book);
  Book[] getAllBooks();
  void delete(int id);
  void delete(String title);
  boolean updateTitle(String title, int id);
  boolean updatePrice(BigDecimal price, int id);
  Book findById(int id);
  Book findByTitle(String title);
  Book[] findAllByPrice(BigDecimal price);
  Book[] findByAuthorName(String name);
  Book[] findAll();
}
