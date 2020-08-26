package com.in28minutes.rest.webservices.restfulwebservices.post.entity;

import com.in28minutes.rest.webservices.restfulwebservices.user.entity.User;

import java.util.Date;

public class Post {

    // postid
    private int postId;
    // dateTime
    private Date creationDate;
    // message
    private String message;
    // details of the poster
    private int userId;

    public Post() {
    }

    public Post(int postId, Date creationDate, String message, int userId) {
        this.postId = postId;
        this.creationDate = creationDate;
        this.message = message;
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
