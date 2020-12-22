package com.quan.rest.webservices.quickreview.exception;


import java.util.Date;

public class ExceptionResponse {
    //timestamp
    //message
    //detail
    private Date timestamp;
    private String message;
    private String detail;
    public ExceptionResponse(Date timestamp,String message,String detail) {
        super();
        this.timestamp=timestamp;
        this.message=message;
        this.detail=detail;
    }
    public String getDetail() {
        return detail;
    }
    public String getMessage() {
        return message;
    }
    public Date getTimestamp() {
        return timestamp;
    }
}
