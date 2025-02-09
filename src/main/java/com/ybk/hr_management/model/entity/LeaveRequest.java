package com.ybk.hr_management.model.entity;

import com.ybk.hr_management.model.enums.Status;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Table("leave_request")
public class LeaveRequest {
    private Long id;
    private Long userId;
    private Long leaveTypeId;
    private LocalDate startDate;
    private LocalDate endDate;
    private int day;
    private String reason;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
