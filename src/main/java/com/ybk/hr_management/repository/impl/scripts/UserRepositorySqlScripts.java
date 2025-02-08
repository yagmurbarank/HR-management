package com.ybk.hr_management.repository.impl.scripts;

public class UserRepositorySqlScripts {
    private static final StringBuilder sqlBuilder = new StringBuilder();

    private UserRepositorySqlScripts() {
    }


    public static final String GET_ALL_USERS =
            sqlBuilder.delete(0, sqlBuilder.length())
                    .append("SELECT * FROM user")
                    .toString();

    public static final String GET_USER_BY_USERNAME =
            sqlBuilder.delete(0, sqlBuilder.length())
                    .append("SELECT * FROM user WHERE username = :username")
                    .toString();

    public static final String CREATE_USER =
            sqlBuilder.delete(0, sqlBuilder.length())
                    .append("INSERT INTO user (name, lastName, department, username, password, role, createdAt, updatedAt) ")
                    .append("VALUES (:name, :lastName, :department, :username, :password, :role, :createdAt, :updatedAt)")
                    .toString();

    public static final String UPDATE_USER =
            sqlBuilder.delete(0, sqlBuilder.length())
                    .append("UPDATE user SET department = :department, roleMethod = :role, updatedAt = :updatedAt WHERE id = :id")
                    .toString();

    public static final String SAVE_USER =
            sqlBuilder.delete(0, sqlBuilder.length())
                    .append("UPDATE user SET name = :name, lastName = :lastName, department = :department, ")
                    .append("username = :username, role = :role, updatedAt = :updatedAt WHERE id = :id")
                    .toString();

    public static final String UPDATE_USER_PASSWORD =
            sqlBuilder.delete(0, sqlBuilder.length())
                    .append("UPDATE USER_LOGIN SET PASSWORD=:password" +
                            "WHERE USER_ID=:Id").toString();

    public static final String UPDATE_USER_LEAVE_REQUEST =
            sqlBuilder.delete(0, sqlBuilder.length())
                    .append("UPDATE user SET leaveRequest = :leaveRequest WHERE id = :userId")
                    .toString();

    public static final String GET_LEAVE_REQUESTS_BY_USER_ID =
            sqlBuilder.delete(0, sqlBuilder.length())
                    .append("SELECT * FROM leave_request WHERE user_id = :userId")
                    .toString();

    public static final String GET_ALL_USERS_BY_DEPARTMENT_ID =
            sqlBuilder.delete(0, sqlBuilder.length())
                    .append("SELECT id FROM user WHERE department_id = :departmentId")
                    .toString();

    public static final String FIND_USER_BY_ID =
            sqlBuilder.delete(0, sqlBuilder.length())
                    .append("SELECT * FROM user WHERE id = :userId")
                    .toString();

    public static final String FIND_DELETED_USER =
            sqlBuilder.delete(0, sqlBuilder.length())
                    .append("SELECT * FROM user WHERE id = :userId AND is_deleted = true")
                    .toString();

    public static final String FIND_PASSIVE_USER =
            sqlBuilder.delete(0, sqlBuilder.length())
                    .append("SELECT * FROM user WHERE id = :userId AND status = 'passive'")
                    .toString();

    public static final String FIND_ACTIVE_USER =
            sqlBuilder.delete(0, sqlBuilder.length())
                    .append("SELECT * FROM user WHERE id = :userId AND status = 'active'")
                    .toString();
}
