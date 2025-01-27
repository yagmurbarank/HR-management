package com.ybk.hr_management.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;


import java.time.LocalDateTime;

@Getter
@Setter

@Table("user")
public class User {
    private Long id;
    private String name;
    private String lastName;
    private String username;
    private String password;
    private String role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
