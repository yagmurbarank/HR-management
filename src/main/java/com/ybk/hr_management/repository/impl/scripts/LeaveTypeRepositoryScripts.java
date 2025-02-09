package com.ybk.hr_management.repository.impl.scripts;

public class LeaveTypeRepositoryScripts {
    private static final StringBuilder sqlBuilder = new StringBuilder();


    public static final String FIND_BY_NAME =
            sqlBuilder.delete(0, sqlBuilder.length())
                    .append("SELECT name FROM leave_type WHERE name = :name")
                    .toString();

    public static final String CREATE_LEAVE_TYPE =
            sqlBuilder.delete(0, sqlBuilder.length())
                    .append("INSERT INTO leave_type (name, day, created_at, updated_at) ")
                    .append("VALUES (:name, :day, :createdAt, :updatedAt)")
                    .toString();

    public static final String CREATE_LEAVE_TYPES =
            sqlBuilder.delete(0, sqlBuilder.length())
                    .append("INSERT INTO leave_type (name, day, created_at, updated_at) ")
                    .append("VALUES (:name, :day, :createdAt, :updatedAt)")
                    .toString();


    public static final String UPDATE_LEAVE_TYPE =
            sqlBuilder.delete(0, sqlBuilder.length())
                    .append("UPDATE leave_type SET name = :name, day = :day, updated_at = :updatedAt WHERE id = :id")
                    .toString();

    public static final String UPDATE_LEAVE_TYPES =
            sqlBuilder.delete(0, sqlBuilder.length())
                    .append("UPDATE leave_type SET name = :name, day = :day, updated_at = :updatedAt WHERE id= :id")
                    .toString();

    public static final String REMOVE_LEAVE_TYPE =
            sqlBuilder.delete(0, sqlBuilder.length())
                    .append("DELETE FROM leave_type WHERE id = :id")
                    .toString();

    public static final String GET_ALL_LEAVE_TYPES =
            sqlBuilder.delete(0, sqlBuilder.length())
                    .append("SELECT * FROM leave_type")
                    .toString();

    public static final String IS_LEAVE_TYPE_VALID =
            sqlBuilder.delete(0, sqlBuilder.length())
                    .append("SELECT * FROM leave_type WHERE id = :id")
                    .toString();
}


