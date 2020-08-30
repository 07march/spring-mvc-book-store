package by.bookstore.service;

import by.bookstore.entity.Author;
import by.bookstore.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService{
 private AuthorRepository authorRepository;

 public AuthorServiceImpl(AuthorRepository authorRepository) {
  this.authorRepository = authorRepository;
 }

 @Override
  public void add(Author a) {
  authorRepository.add(a);
  }

  @Override
  public void delete(int id) {
  authorRepository.delete(id);
  }

  @Override
  public boolean updateAuthorById(String name, int id) {
    return authorRepository.updateAuthorById(name, id);
  }

  @Override
  public Author findById(int id) {
    return authorRepository.findById(id);
  }

  @Override
  public Author findByName(String name) {
    return authorRepository.findByName(name);
  }

  @Override
  public Author[] findAll() {
    return authorRepository.findAll();
  }
}
