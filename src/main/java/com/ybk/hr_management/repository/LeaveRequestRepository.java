package com.ybk.hr_management.repository;

import com.ybk.hr_management.model.entity.LeaveRequest;
import com.ybk.hr_management.model.entity.LeaveType;
import com.ybk.hr_management.model.enums.Status;

import java.util.List;

public interface LeaveRequestRepository {
    void createLeaveRequest(LeaveRequest leaveRequest);

    void updateLeaveRequest(LeaveType leaveRequest);

    void cancelLeaveRequest(LeaveType leaveRequest);

    List<LeaveRequest> getLeaveRequestsByUserId(String userId);

    List<LeaveRequest> getLeaveRequestsByStatus(Status status);

    LeaveRequest getLeaveRequestById(String requestId);

    boolean isLeaveRequestValid(LeaveRequest leaveRequest);

    void notifyLeaveRequestCreated(LeaveRequest leaveRequest);

    void notifyLeaveRequestUpdated(LeaveRequest leaveRequest);

    void notifyLeaveRequestCancelled(LeaveRequest leaveRequest);

    void createLeaveRequests(List<LeaveRequest> leaveRequests);

    void updateLeaveRequests(List<LeaveType> leaveTypes);

    void cancelLeaveRequests(List<LeaveType> leaveTypes);
}
