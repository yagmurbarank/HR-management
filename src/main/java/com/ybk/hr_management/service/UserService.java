package com.ybk.hr_management.service;

import com.ybk.hr_management.exception.DatabaseException;
import com.ybk.hr_management.exception.NotExistException;
import com.ybk.hr_management.model.entity.User;
import com.ybk.hr_management.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public List<User> getAllUsers() {
        try {
            return userRepository.getAllUsers();
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    public Optional<User> getUserByUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }

        try {
            return userRepository.getUserByUsername(username);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    public void createUser(User user) {
        if (user == null) {
            throw new DatabaseException(new NullPointerException("User cannot be null"));
        }

        if (userRepository.getUserByUsername(user.getUsername()).isPresent()) {
            throw new NotExistException("Username already exists");
        }

        try {
            userRepository.createUser(user);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    public void updatePassword(Long userId, String newPassword) {
        if (userId == null) {
            throw new DatabaseException(new NullPointerException("User ID cannot be null"));
        }
        if (newPassword == null || newPassword.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        try {
            userRepository.updatePassword(userId, newPassword);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    public void saveUser(User user) {
        if (user == null) {
            throw new DatabaseException(new NullPointerException("User cannot be null"));
        }

        try {
            userRepository.saveUser(user);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    public void updateUser(User user) {
        if (user == null) {
            throw new DatabaseException(new NullPointerException("User cannot be null"));
        }

        try {
            userRepository.updateUser(user);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    public void deleteUser(Long userId) {
        if (userId == null) {
            throw new DatabaseException(new NullPointerException("User ID cannot be null"));
        }
        if (userId <= 0) {
            throw new IllegalArgumentException("Invalid user ID");
        }

        try {
            userRepository.deleteUser(userId);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    public void updateUserLeaveRequest(User user) {
        if (user == null) {
            throw new DatabaseException(new NullPointerException("User cannot be null"));
        }

        try {
            userRepository.updateUserLeaveRequest(user);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    public User findUserById(Long userId) {
        if (userId == null) {
            throw new DatabaseException(new NullPointerException("User ID cannot be null"));
        }
        if (userId <= 0) {
            throw new IllegalArgumentException("Invalid user ID");
        }

        try {
            return userRepository.findUserById(userId).orElse(null);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }
}