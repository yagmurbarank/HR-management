package com.ybk.hr_management.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@Table("leave_type")
public class LeaveType {

    private Long id;
    private String name;
    private int day;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
