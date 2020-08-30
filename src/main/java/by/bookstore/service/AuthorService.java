package by.bookstore.service;

import by.bookstore.entity.Author;

public interface AuthorService {
  void add(Author a);
  void delete(int id);
  boolean updateAuthorById(String name, int id);
  Author findById(int id);
  Author findByName(String name);
  Author[] findAll();
}
