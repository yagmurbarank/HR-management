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
                    .append("INSERT INTO user (first_name, last_name, department, username, password, role, created_at, updated_at) ")
                    .append("VALUES (:name, :lastName, :department, :username, :password, :role, :createdAt, :updatedAt)")
                    .toString();

    public static final String UPDATE_USER =
            sqlBuilder.delete(0, sqlBuilder.length())
                    .append("UPDATE user SET password = :password, department = :department, role = :role, updated_at = :updated_at WHERE id = :id")
                    .toString();
    public static final String DELETE_USER =
            sqlBuilder.delete(0, sqlBuilder.length())
                    .append("DELETE user WHERE id = :id")
                    .toString();

    public static final String SAVE_USER =
            sqlBuilder.delete(0, sqlBuilder.length())
                    .append("UPDATE user SET first_name = :name, last_name = :lastName, department = :department, ")
                    .append("username = :username, role = :role, updated_at = :updatedAt WHERE id = :id")
                    .toString();

    public static final String UPDATE_USER_PASSWORD =
            sqlBuilder.delete(0, sqlBuilder.length())
                    .append("UPDATE USER_LOGIN SET PASSWORD=:password" +
                            "WHERE id=:Id").toString();

    public static final String UPDATE_USER_LEAVE_REQUEST =
            sqlBuilder.delete(0, sqlBuilder.length())
                    .append("UPDATE user SET leave_request = :leaveRequest WHERE user_id = :userId")
                    .toString();

    public static final String FIND_USER_BY_ID =
            sqlBuilder.delete(0, sqlBuilder.length())
                    .append("SELECT * FROM user WHERE id = :id")
                    .toString();

}
