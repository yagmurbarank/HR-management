package com.ybk.hr_management.service;

import com.ybk.hr_management.exception.DatabaseException;
import com.ybk.hr_management.exception.NotExistException;
import com.ybk.hr_management.model.entity.LeaveRequest;
import com.ybk.hr_management.model.enums.Status;
import com.ybk.hr_management.repository.LeaveRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeaveRequestService {

    private final LeaveRequestRepository leaveRequestRepository;

    public void createLeaveRequest(LeaveRequest leaveRequest) {
        if (leaveRequest == null) {
            throw new DatabaseException(new NullPointerException("Leave Request cannot be null"));
        }

        if (leaveRequest.getId() != null) {
            throw new NotExistException("Leave Request already exists");
        }

        try {
            leaveRequestRepository.createLeaveRequest(leaveRequest);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    public void updateLeaveRequest(LeaveRequest leaveRequest) {
        if (leaveRequest == null) {
            throw new DatabaseException(new NullPointerException("Leave Request cannot be null"));
        }

        try {
            leaveRequestRepository.updateLeaveRequest(leaveRequest);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    public void cancelLeaveRequest(LeaveRequest leaveRequest) {
        if (leaveRequest == null) {
            throw new DatabaseException(new NullPointerException("Leave Request cannot be null"));
        }

        try {
            leaveRequestRepository.cancelLeaveRequest(leaveRequest);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    public List<LeaveRequest> getLeaveRequestsByUserId(Long userId) {
        if (userId == null) {
            throw new NotExistException("User ID cannot be null");
        }

        try {
            return leaveRequestRepository.getLeaveRequestsByUserId(userId);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    public List<LeaveRequest> getLeaveRequestsByStatus(Status status) {
        if (status == null) {
            throw new NotExistException("Status cannot be null");
        }

        try {
            return leaveRequestRepository.getLeaveRequestsByStatus(status);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    public LeaveRequest getLeaveRequestById(String requestId) {
        if (requestId == null || requestId.trim().isEmpty()) {
            throw new NotExistException("Request ID cannot be null or empty");
        }

        try {
            LeaveRequest leaveRequest = leaveRequestRepository.getLeaveRequestById(requestId);
            if (leaveRequest == null) {
                throw new NotExistException("Leave Request not found");
            }
            return leaveRequest;
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    public boolean isLeaveRequestValid(LeaveRequest leaveRequest) {
        if (leaveRequest == null) {
            throw new DatabaseException(new NullPointerException("Leave Request cannot be null"));
        }

        try {
            return leaveRequestRepository.isLeaveRequestValid(leaveRequest);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    public void notifyLeaveRequestCreated(LeaveRequest leaveRequest) {
        if (leaveRequest == null) {
            throw new DatabaseException(new NullPointerException("Leave Request cannot be null"));
        }

        try {
            leaveRequestRepository.notifyLeaveRequestCreated(leaveRequest);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    public void notifyLeaveRequestUpdated(LeaveRequest leaveRequest) {
        if (leaveRequest == null) {
            throw new DatabaseException(new NullPointerException("Leave Request cannot be null"));
        }

        try {
            leaveRequestRepository.notifyLeaveRequestUpdated(leaveRequest);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    public void notifyLeaveRequestCancelled(LeaveRequest leaveRequest) {
        if (leaveRequest == null) {
            throw new DatabaseException(new NullPointerException("Leave Request cannot be null"));
        }

        try {
            leaveRequestRepository.notifyLeaveRequestCancelled(leaveRequest);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    public void createLeaveRequests(List<LeaveRequest> leaveRequests) {
        if (leaveRequests == null || leaveRequests.isEmpty()) {
            throw new NotExistException("Leave Requests cannot be null or empty");
        }

        try {
            leaveRequestRepository.createLeaveRequests(leaveRequests);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    public void updateLeaveRequests(List<LeaveRequest> leaveRequests) {
        if (leaveRequests == null || leaveRequests.isEmpty()) {
            throw new NotExistException("Leave Requests cannot be null or empty");
        }

        try {
            leaveRequestRepository.updateLeaveRequests(leaveRequests);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    public void cancelLeaveRequests(List<LeaveRequest> leaveRequests) {
        if (leaveRequests == null || leaveRequests.isEmpty()) {
            throw new NotExistException("Leave Requests cannot be null or empty");
        }

        try {
            leaveRequestRepository.cancelLeaveRequests(leaveRequests);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }
}
