package com.ybk.hr_management.repository.impl;

import com.ybk.hr_management.model.entity.User;
import com.ybk.hr_management.repository.UserRepository;
import com.ybk.hr_management.repository.impl.scripts.UserRepositorySqlScripts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;


@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final Sql2o sql2o;
    private static final Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);

    @Override
    public List<User> getAllUsers() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(UserRepositorySqlScripts.GET_ALL_USERS)
                    .executeAndFetch(User.class);
        } catch (DataAccessException e) {
            logger.error("Error fetching all users", e);
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
        } catch (DataAccessException e) {
            logger.error("Error fetching user by username: {}", username, e);
            return Optional.empty();
        }
    }

    @Override
    public void createUser(User user) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery(UserRepositorySqlScripts.CREATE_USER)
                    .bind(user)
                    .executeUpdate();
        } catch (DataAccessException e) {
            logger.error("Error creating user: {}", user.getUsername(), e);
            throw new RuntimeException("Error creating user. See logs for details.", e);
        }
    }

    @Override
    public void updateUser(User user) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery(UserRepositorySqlScripts.UPDATE_USER)
                    .bind(user)
                    .executeUpdate();
        } catch (DataAccessException e) {
            logger.error("Error updating user: {}", user.getUsername(), e);
            throw new RuntimeException("Error updating user. See logs for details.", e);
        }
    }

    @Override
    public void saveUser(User user) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery(UserRepositorySqlScripts.SAVE_USER)
                    .bind(user)
                    .executeUpdate();
        } catch (DataAccessException e) {
            logger.error("Error saving user: {}", user.getUsername(), e);
            throw new RuntimeException("Error saving user. See logs for details.", e);
        }
    }

    @Override
    public void updatePassword(Long userId, String password) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery(UserRepositorySqlScripts.UPDATE_USER_PASSWORD)
                    .addParameter("userId", userId)
                    .addParameter("password", password)
                    .executeUpdate();
        } catch (DataAccessException e) {
            logger.error("Error updating password for user ID: {}", userId, e);
            throw new RuntimeException("Error updating password. See logs for details.", e);
        }
    }

    @Override
    public void updateUserLeaveRequest(User user) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery(UserRepositorySqlScripts.UPDATE_USER_LEAVE_REQUEST)
                    .bind(user)
                    .executeUpdate();
        } catch (DataAccessException e) {
            logger.error("Error updating leave request for user: {}", user.getUsername(), e);
            throw new RuntimeException("Error updating leave request. See logs for details.", e);
        }
    }

    @Override
    public void deleteUser(Long id) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery(UserRepositorySqlScripts.DELETE_USER)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (DataAccessException e) {
            logger.error("Error deleting user with ID: {}", id, e);
            throw new RuntimeException("Error deleting user. See logs for details.", e);
        }
    }

    @Override
    public Optional<User> findUserById(Long userId) {
        try (Connection conn = sql2o.open()) {
            User user = conn.createQuery(UserRepositorySqlScripts.FIND_USER_BY_ID)
                    .addParameter("userId", userId)
                    .executeAndFetchFirst(User.class);
            return Optional.ofNullable(user);
        } catch (DataAccessException e) {
            logger.error("Error finding user by ID: {}", userId, e);
            return Optional.empty();
        }
    }
}
