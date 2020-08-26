package com.in28minutes.rest.webservices.restfulwebservices.post.exception;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

public class ExceptionResponse {
    // timestamp
    private Date dateTime;
    // message
    private String message;
    // detail
    private String details;

    public ExceptionResponse(Date dateTime, String message, String details) {

        this.dateTime = dateTime;
        this.message = message;
        this.details = details;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
