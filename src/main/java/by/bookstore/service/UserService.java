package by.bookstore.service;

import by.bookstore.entity.User;

public interface UserService {
  User findById(int id);

  void changeStatus(boolean a, int id);

  User findByEmail(String email);

  void add(User user);

  void delete(String email);

  void updateFirstName(String newFirstName, String email);

  void updateLastName(String newLastName, String email);

  void updatePassword(String newPassword, String email);


}