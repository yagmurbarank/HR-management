package com.ybk.hr_management.service;

import com.ybk.hr_management.exception.DatabaseException;
import com.ybk.hr_management.exception.NotExistException;
import com.ybk.hr_management.model.entity.LeaveType;
import com.ybk.hr_management.repository.LeaveTypeRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class LeaveTypeService {

    private final LeaveTypeRepository leaveTypeRepository;
    private static final Logger logger = LoggerFactory.getLogger(LeaveTypeService.class);

    public void createLeaveType(LeaveType leaveType) throws NotExistException {
        if (leaveType == null) {
            throw new DatabaseException(new NullPointerException("Leave Type cannot be null"));
        }

        if (leaveTypeRepository.isLeaveTypeValid(leaveType)) {
            throw new NotExistException("Leave Type already exists");
        }

        leaveTypeRepository.createLeaveType(leaveType);
    }

    public void deleteLeaveType(LeaveType leaveType) {
        if (leaveType == null) {
            throw new DatabaseException(new NullPointerException("Leave Type cannot be null"));
        }

        if (leaveType.getId() == null) {
            throw new NotExistException("Leave Type does not exist");
        }

        try {
            leaveTypeRepository.removeLeaveType(leaveType);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    public void updateLeaveType(LeaveType leaveType) {
        if (leaveType == null) {
            throw new DatabaseException(new NullPointerException("Leave Type cannot be null"));
        }

        try {
            leaveTypeRepository.updateLeaveType(leaveType);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    public List<LeaveType> getAllLeaveType() {
        try {
            return leaveTypeRepository.findAllLeaveTypes();
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    public void createLeaveTypes(List<LeaveType> leaveTypes) {
        if (leaveTypes == null || leaveTypes.isEmpty()) {
            throw new NotExistException("Leave Types cannot be null or empty");
        }

        try {
            leaveTypeRepository.createLeaveTypes(leaveTypes);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    public boolean isLeaveTypeValid(LeaveType leaveType) {
        return leaveTypeRepository.isLeaveTypeValid(leaveType);
    }

    public void updateLeaveTypes(List<LeaveType> leaveTypes) {
        if (leaveTypes == null || leaveTypes.isEmpty()) {
            throw new NotExistException("Leave Types cannot be null or empty");
        }

        try {
            leaveTypeRepository.updateLeaveTypes(leaveTypes);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }
}
