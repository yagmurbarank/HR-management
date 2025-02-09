package com.ybk.hr_management.repository;


import com.ybk.hr_management.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> getAllUsers();

    Optional<User> getUserByUsername(String username);

    void createUser(User user);

    void updatePassword(Long userId, String newPassword);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Long userId);

    void updateUserLeaveRequest(User user);

    Optional<User> findUserById(Long userId);

}
