package com.ybk.hr_management.repository.impl;

import com.ybk.hr_management.model.entity.LeaveRequest;
import com.ybk.hr_management.model.entity.User;
import com.ybk.hr_management.repository.UserRepository;
import com.ybk.hr_management.repository.impl.scripts.UserRepositorySqlScripts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final Sql2o sql2o;

    @Override
    public List<User> getAllUsers() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(UserRepositorySqlScripts.GET_ALL_USERS)
                    .executeAndFetch(User.class);
        } catch (Exception e) {
            System.err.println("Error while fetching using " + e.getMessage());
            return List.of();
        }
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        try (Connection conn = sql2o.open()) {
            User user = conn.createQuery(UserRepositorySqlScripts.GET_USER_BY_USERNAME)
                    .addParameter("username", username)
                    .executeAndFetchFirst(User.class);
            return Optional.ofNullable(user);
        }
    }

    @Override
    public void createUser(User user) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery(UserRepositorySqlScripts.CREATE_USER)
                    .bind(user)
                    .executeUpdate();
        }
    }

    @Override
    public void updateUser(User user) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery(UserRepositorySqlScripts.UPDATE_USER)
                    .bind(user).executeUpdate();
        }

    }

    @Override
    public void saveUser(User user) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery(UserRepositorySqlScripts.SAVE_USER)
                    .bind(user).executeUpdate();
        }
    }

    @Override
    public void updatePassword(Long userId, String password) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery(UserRepositorySqlScripts.UPDATE_USER_PASSWORD)
                    .bind(userId).executeUpdate();
        }
    }

    @Override
    public void updateUserLeaveRequest(User user) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery(UserRepositorySqlScripts.UPDATE_USER_LEAVE_REQUEST)
                    .bind(user).executeUpdate();
        }
    }

    @Override
    public List<LeaveRequest> getLeaveRequestsByUserId(Long userId) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(UserRepositorySqlScripts.GET_LEAVE_REQUESTS_BY_USER_ID)
                    .addParameter("userId", userId)
                    .executeAndFetch(LeaveRequest.class);
        } catch (Exception e) {
            System.err.println("Error fetching leave requests for user ID " + userId + ": " + e.getMessage());
            return List.of();
        }
    }

    @Override
    public List<Long> getAllUsersByDepartmentId(Long departmentId) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(UserRepositorySqlScripts.GET_ALL_USERS_BY_DEPARTMENT_ID)
                    .addParameter("departmentId", departmentId)
                    .executeAndFetch(Long.class);
        } catch (Exception e) {
            System.err.println("Error fetching user IDs for department ID " + departmentId + ": " + e.getMessage());
            return List.of();
        }
    }

    @Override
    public Optional<User> findUserById(Long userId) {
        try (Connection conn = sql2o.open()) {
            User user = conn.createQuery(UserRepositorySqlScripts.FIND_USER_BY_ID)
                    .addParameter("userId", userId)
                    .executeAndFetchFirst(User.class);

            return Optional.ofNullable(user);

        } catch (Exception e) {
            System.err.println("Error finding user by ID " + e.getMessage());
            return Optional.empty();
        }

    }

    @Override
    public Optional<User> findDeletedUser(Long userId) {
        try (Connection conn = sql2o.open()) {
            User user = conn.createQuery(UserRepositorySqlScripts.FIND_DELETED_USER)
                    .addParameter("userId", userId)
                    .executeAndFetchFirst(User.class);

            return Optional.ofNullable(user);

        } catch (Exception e) {
            System.err.println("Error finding deleted user" + e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> findPassiveUser(Long userId) {
        try (Connection conn = sql2o.open()) {
            User user = conn.createQuery(UserRepositorySqlScripts.FIND_PASSIVE_USER)
                    .addParameter("userId", userId)
                    .executeAndFetchFirst(User.class);

            return Optional.ofNullable(user);

        } catch (Exception e) {
            System.err.println("Error finding passive user" + e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> findActiveUser(Long userId) {
        try (Connection conn = sql2o.open()) {
            User user = conn.createQuery(UserRepositorySqlScripts.FIND_ACTIVE_USER)
                    .addParameter("userId", userId)
                    .executeAndFetchFirst(User.class);

            return Optional.ofNullable(user);

        } catch (Exception e) {
            System.err.println("Error finding active user" + e.getMessage());
            return Optional.empty();
        }
    }

}
