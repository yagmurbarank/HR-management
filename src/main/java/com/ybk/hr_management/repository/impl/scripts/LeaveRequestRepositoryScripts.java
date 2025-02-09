package com.ybk.hr_management.repository.impl.scripts;


public class LeaveRequestRepositoryScripts {
    private static final StringBuilder sqlBuilder = new StringBuilder();


    public static final String CREATE_LEAVE_REQUEST =
            sqlBuilder.delete(0, sqlBuilder.length())
                    .append("INSERT INTO leave_request (id, user_id, type_id, start_date," +
                            "end_date, day, reason, status, created_at, updated_at) ")
                    .append("VALUES (:id, :userId, :leaveTypeId, :startDate, :endDate, :day, " +
                            ":reason, :status, :createdAt, :updatedAt)")
                    .toString();
    public static final String UPDATE_LEAVE_REQUEST =
            sqlBuilder.delete(0, sqlBuilder.length())
                    .append("UPDATE leave_request SET type_id = :leaveTypeId, start_date = :startDate," +
                            " end_date= :andDate, day = :day, reason = :reason, " +
                            "status = :status, updated_at = :updated_at WHERE id = :id")
                    .toString();

    public static final String CANCEL_LEAVE_REQUEST =
            sqlBuilder.delete(0, sqlBuilder.length())
                    .append("DELETE FROM leave_request WHERE id = :id")
                    .toString();
    public static final String GET_LEAVE_REQUESTS_BY_USER_ID =
            sqlBuilder.delete(0, sqlBuilder.length())
                    .append("SELECT * FROM leave_request WHERE user_id = :userId")
                    .toString();
    public static final String GET_LEAVE_REQUESTS_BY_STATUS =
            sqlBuilder.delete(0, sqlBuilder.length())
                    .append("SELECT * FROM leave_request WHERE status = :status")
                    .toString();
    public static final String GET_LEAVE_REQUEST_BY_ID =
            sqlBuilder.delete(0, sqlBuilder.length())
                    .append("SELECT * FROM leave_request WHERE id = :id")
                    .toString();

    public static final String IS_LEAVE_REQUEST_VALID =
            sqlBuilder.delete(0, sqlBuilder.length())
                    .append("SELECT * FROM leave_request WHERE id = :id")
                    .toString();


}
