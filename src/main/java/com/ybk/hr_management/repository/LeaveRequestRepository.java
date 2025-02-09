package com.ybk.hr_management.repository;

import com.ybk.hr_management.model.entity.LeaveRequest;
import com.ybk.hr_management.model.enums.Status;

import java.util.List;

public interface LeaveRequestRepository {
    void createLeaveRequest(LeaveRequest leaveRequest);

    void updateLeaveRequest(LeaveRequest leaveRequest);

    void cancelLeaveRequest(LeaveRequest leaveRequest);

    List<LeaveRequest> getLeaveRequestsByUserId(Long userId);

    List<LeaveRequest> getLeaveRequestsByStatus(Status status);

    LeaveRequest getLeaveRequestById(String requestId);

    boolean isLeaveRequestValid(LeaveRequest leaveRequest);

    void notifyLeaveRequestCreated(LeaveRequest leaveRequest);

    void notifyLeaveRequestUpdated(LeaveRequest leaveRequest);

    void notifyLeaveRequestCancelled(LeaveRequest leaveRequest);

    void createLeaveRequests(List<LeaveRequest> leaveRequests);

    void updateLeaveRequests(List<LeaveRequest> leaveRequests);

    void cancelLeaveRequests(List<LeaveRequest> leaveRequests);

}
