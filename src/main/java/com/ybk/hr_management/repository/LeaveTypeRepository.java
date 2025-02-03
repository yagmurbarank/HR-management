package com.ybk.hr_management.repository;


import com.ybk.hr_management.model.LeaveType;

import java.util.List;
import java.util.Optional;

public interface LeaveTypeRepository  {
    Optional<LeaveType> findByName(String name);

    void createLeaveType(LeaveType leaveType);

    void createLeaveTypes(List<LeaveType> leaveTypes); // Batch operation

    void updateLeaveType(LeaveType leaveType);

    void updateLeaveTypes(List<LeaveType> leaveTypes);

    void removeLeaveType(LeaveType leaveType);

    List<LeaveType> findAllLeaveTypes(); // New method

    boolean isLeaveTypeValid(LeaveType leaveType);

}
