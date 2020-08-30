package by.bookstore.service;

import by.bookstore.entity.Book;
import by.bookstore.entity.Order;
import by.bookstore.entity.Store;
import by.bookstore.entity.User;

public interface OrderService {
  void add(Order order);
  void delete(int id);
  boolean update(Book[] books, int id);
  Order findByStore(Store store);
  Order[] findAll();
  Order findByUser(User user);
  Order[] findAllByStore(Store store);
}
