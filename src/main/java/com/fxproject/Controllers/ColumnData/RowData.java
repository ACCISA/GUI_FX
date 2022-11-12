package com.fxproject.Controllers.ColumnData;

public class RowData {
    private String userID;
    private String caller;
    private String username;
    private String original_password;
    private String current_password;
    private String createDate;

    public RowData(String userID,String caller, String username, String original_password, String current_password, String createDate) {
        this.userID = userID;
        this.caller = caller;
        this.username = username;
        this.original_password = original_password;
        this.current_password = current_password;
        this.createDate = createDate;
    }

    public String getUserID() {
        return userID;
    }

    public String getCaller() {
        return caller;
    }

    public String getUsername() {
        return username;
    }

    public String getOriginal_password() {
        return original_password;
    }

    public String getCurrent_password() {
        return current_password;
    }

    public String getCreateDate() {
        return createDate;
    }
}
