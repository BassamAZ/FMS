package com.alten.fms.model;

import org.springframework.data.annotation.Id;

public enum Status {

    CONNECTED ("1","Connected Status"),
    DICONNECTED("0","Disconnected Status");

    private String statusCode;
    private String statusDesc;

    Status (String statusCode, String statusDesc){
        this.statusCode= statusCode;
        this.statusDesc=statusDesc;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }
}
