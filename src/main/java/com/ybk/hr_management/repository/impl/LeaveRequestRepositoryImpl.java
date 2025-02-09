package com.ybk.hr_management.repository.impl;

import com.ybk.hr_management.model.entity.LeaveRequest;
import com.ybk.hr_management.model.enums.Status;
import com.ybk.hr_management.repository.LeaveRequestRepository;
import com.ybk.hr_management.repository.impl.scripts.LeaveRequestRepositoryScripts;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class LeaveRequestRepositoryImpl implements LeaveRequestRepository {
    private final Sql2o sql2o;
    private static final Logger logger = LoggerFactory.getLogger(LeaveRequestRepositoryImpl.class);


    @Override
    public void createLeaveRequest(LeaveRequest leaveRequest) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery(LeaveRequestRepositoryScripts.CREATE_LEAVE_REQUEST)
                    .bind(leaveRequest)
                    .executeUpdate();
        } catch (Exception e) {
            logger.error("Error creating leave request", e);
        }
    }

    @Override
    public void updateLeaveRequest(LeaveRequest leaveRequest) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery(LeaveRequestRepositoryScripts.UPDATE_LEAVE_REQUEST)
                    .bind(leaveRequest)
                    .executeUpdate();
        } catch (Exception e) {
            logger.error("Error updating leave request", e);
        }
    }

    @Override
    public void cancelLeaveRequest(LeaveRequest leaveRequest) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery(LeaveRequestRepositoryScripts.CANCEL_LEAVE_REQUEST)
                    .bind(leaveRequest)
                    .executeUpdate();
        } catch (Exception e) {
            logger.error("Error cancelling leave request", e);
        }
    }

    @Override
    public List<LeaveRequest> getLeaveRequestsByUserId(Long userId) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(LeaveRequestRepositoryScripts.GET_LEAVE_REQUESTS_BY_USER_ID)
                    .addParameter("userId", userId)
                    .executeAndFetch(LeaveRequest.class);
        } catch (Exception e) {
            logger.error("Error fetching leave requests by user ID: {}", userId, e);
            return List.of();
        }
    }

    @Override
    public List<LeaveRequest> getLeaveRequestsByStatus(Status status) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(LeaveRequestRepositoryScripts.GET_LEAVE_REQUESTS_BY_STATUS)
                    .addParameter("status", status.toString())
                    .executeAndFetch(LeaveRequest.class);
        } catch (Exception e) {
            logger.error("Error fetching leave requests by status: {}", status, e);
            return List.of();
        }
    }

    @Override
    public LeaveRequest getLeaveRequestById(String id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(LeaveRequestRepositoryScripts.GET_LEAVE_REQUEST_BY_ID)
                    .addParameter("id", id)
                    .executeAndFetchFirst(LeaveRequest.class);
        } catch (Exception e) {
            logger.error("Error fetching leave request by ID: {}", id, e);
            return null;
        }
    }

    @Override
    public boolean isLeaveRequestValid(LeaveRequest leaveRequest) {
        try (Connection conn = sql2o.open()) {
            LeaveRequest fetchedLeaveRequest = conn.createQuery(LeaveRequestRepositoryScripts.IS_LEAVE_REQUEST_VALID)
                    .bind(leaveRequest)
                    .executeAndFetchFirst(LeaveRequest.class);

            return fetchedLeaveRequest != null;

        } catch (Exception e) {
            logger.error("Error checking if leave request is valid: {}", leaveRequest, e);
            return false;
        }
    }

    @Override
    public void notifyLeaveRequestCreated(LeaveRequest leaveRequest) {
        logger.info("Leave request created: {}", leaveRequest);
    }

    @Override
    public void notifyLeaveRequestUpdated(LeaveRequest leaveRequest) {
        logger.info("Leave request updated: {}", leaveRequest);
    }

    @Override
    public void notifyLeaveRequestCancelled(LeaveRequest leaveRequest) {
        logger.info("Leave request cancelled: {}", leaveRequest);
    }

    @Override
    public void createLeaveRequests(List<LeaveRequest> leaveRequests) {
        try (Connection conn = sql2o.open()) {
            for (LeaveRequest leaveRequest : leaveRequests) {
                conn.createQuery(LeaveRequestRepositoryScripts.CREATE_LEAVE_REQUEST)
                        .bind(leaveRequest)
                        .executeUpdate();
            }
        } catch (Exception e) {
            logger.error("Error creating leave requests", e);
        }
    }

    @Override
    public void updateLeaveRequests(List<LeaveRequest> leaveRequests) {
        try (Connection conn = sql2o.open()) {
            for (LeaveRequest leaveRequest : leaveRequests) {
                conn.createQuery(LeaveRequestRepositoryScripts.UPDATE_LEAVE_REQUEST)
                        .bind(leaveRequest)
                        .executeUpdate();
            }
        } catch (Exception e) {
            logger.error("Error updating leave requests", e);
        }
    }

    @Override
    public void cancelLeaveRequests(List<LeaveRequest> leaveRequests) {
        try (Connection conn = sql2o.open()) {
            for (LeaveRequest leaveRequest : leaveRequests) {
                conn.createQuery(LeaveRequestRepositoryScripts.CANCEL_LEAVE_REQUEST)
                        .bind(leaveRequest)
                        .executeUpdate();
            }
        } catch (Exception e) {
            logger.error("Error cancelling leave requests", e);
        }
    }
}
