package by.bookstore.service;

import by.bookstore.entity.Role;
import by.bookstore.entity.User;
import by.bookstore.repository.UserRepository;
import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.SHA256Digest;
import org.postgresql.util.MD5Digest;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void changeStatus(boolean a, int id) {
        userRepository.updateStatus(a, id);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void add(User user) {
        user.setRole(Role.USER);
        userRepository.add(user);
    }

    @Override
    public void delete(String email) {
        userRepository.delete(email);
    }

    @Override
    public void updateFirstName(String newFirstName, String email) {
        userRepository.updateFirstName(newFirstName, email);
    }

    @Override
    public void updateLastName(String newLastName, String email) {
        userRepository.updateLastName(newLastName, email);
    }

    @Override
    public void updatePassword(String newPassword, String email) {
        userRepository.updatePassword(newPassword, email);
    }


}
