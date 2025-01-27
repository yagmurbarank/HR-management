package com.ybk.hr_management.model;

import com.ybk.hr_management.model.enums.Status;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@Table("leave_request")
public class LeaveRequest {
    private Long id;
    private String name;
    private String reason;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Status status;
    private Long userId;
    private Long leaveTypeId;

}
