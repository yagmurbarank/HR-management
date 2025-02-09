package com.ybk.hr_management.repository.impl;


import com.ybk.hr_management.model.entity.LeaveType;
import com.ybk.hr_management.repository.LeaveTypeRepository;
import com.ybk.hr_management.repository.impl.scripts.LeaveTypeRepositoryScripts;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LeaveTypeRepositoryImpl implements LeaveTypeRepository {

    private final Sql2o sql2o;
    private static final Logger logger = LoggerFactory.getLogger(LeaveTypeRepositoryImpl.class);

    @Override
    public Optional<LeaveType> findByName(String name) {
        try (Connection conn = sql2o.open()) {
            LeaveType leaveType = conn.createQuery(LeaveTypeRepositoryScripts.FIND_BY_NAME)
                    .addParameter("name", name)
                    .executeAndFetchFirst(LeaveType.class);
            return Optional.ofNullable(leaveType);

        } catch (DataAccessException e) {
            logger.error("Error finding leave type with name: {}", name, e);
            return Optional.empty();
        }
    }

    @Override
    public void createLeaveType(LeaveType leaveType) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery(LeaveTypeRepositoryScripts.CREATE_LEAVE_TYPE)
                    .bind(leaveType)
                    .executeUpdate();
        } catch (DataAccessException e) {
            logger.error("Error creating leave type: {}", leaveType, e);
            throw new RuntimeException("Failed to create leave type. See logs for details", e);
        }
    }

    @Override
    public void createLeaveTypes(List<LeaveType> leaveTypes) {
        try (Connection conn = sql2o.open()) {
            String sql = LeaveTypeRepositoryScripts.CREATE_LEAVE_TYPES;
            for (LeaveType leaveType : leaveTypes) {
                conn.createQuery(sql)
                        .bind(leaveType)
                        .executeUpdate();
            }
        } catch (DataAccessException e) {
            logger.error("Failed to create leave types: {}", leaveTypes, e);
            throw new RuntimeException("Failed to create leave types. See logs for details", e);
        }
    }

    @Override
    public void updateLeaveType(LeaveType leaveType) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery(LeaveTypeRepositoryScripts.UPDATE_LEAVE_TYPE)
                    .bind(leaveType)
                    .executeUpdate();
        } catch (DataAccessException e) {
            logger.error("Failed to update leave type: {}", leaveType, e);
            throw new RuntimeException("Failed to update leave type. See logs for details", e);
        }
    }

    @Override
    public void updateLeaveTypes(List<LeaveType> leaveTypes) {
        try (Connection conn = sql2o.open()) {
            String sql = LeaveTypeRepositoryScripts.UPDATE_LEAVE_TYPES;

            for (LeaveType leaveType : leaveTypes) {
                conn.createQuery(sql)
                        .bind(leaveType)
                        .executeUpdate();
            }
        } catch (DataAccessException e) {
            logger.error("Failed to update leave types: {}", leaveTypes, e);
            throw new RuntimeException("Failed to update leave types. See logs for details", e);
        }
    }

    @Override
    public void removeLeaveType(LeaveType leaveType) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery(LeaveTypeRepositoryScripts.REMOVE_LEAVE_TYPE)
                    .bind(leaveType)
                    .executeUpdate();
        } catch (DataAccessException e) {
            logger.error("Failed to remove leave type: {}", leaveType, e);
            throw new RuntimeException("Failed to remove leave type. See logs for details", e);
        }
    }

    @Override
    public List<LeaveType> findAllLeaveTypes() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(LeaveTypeRepositoryScripts.GET_ALL_LEAVE_TYPES)
                    .executeAndFetch(LeaveType.class);
        } catch (DataAccessException e) {
            logger.error("Error while fetching leave types", e);
            return Collections.emptyList();
        }
    }

    @Override
    public boolean isLeaveTypeValid(LeaveType leaveType) {
        try (Connection conn = sql2o.open()) {
            LeaveType fetchedLeaveType = conn.createQuery(LeaveTypeRepositoryScripts.IS_LEAVE_TYPE_VALID)
                    .bind(leaveType)
                    .executeAndFetchFirst(LeaveType.class);

            return fetchedLeaveType != null;

        } catch (DataAccessException e) {
            logger.error("Error checking if leave type is valid: {}", leaveType, e);
            return false;
        }
    }
}
