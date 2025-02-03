package com.ybk.hr_management.repository;


import com.ybk.hr_management.model.LeaveRequest;
import com.ybk.hr_management.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> getAllUsers();

    Optional<User> getUserByUsername(String username);

    void createUser(User user);

    void updatePassword(Long userId, String newPassword);

    void saveUser(User user);

    void updateUser(User user);

    void updateUserLeaveRequest(User user);

    List<LeaveRequest> getLeaveRequestsByUserId(Long userId);

    List<Long> getAllUsersByDepartmentId(Long departmentId);

    Optional<User> findUserById(Long userId);

    Optional<User> findDeletedUser(Long userId);

    Optional<User> findPassiveUser(Long userId);

    Optional<User> findActiveUser(Long userId);

}
