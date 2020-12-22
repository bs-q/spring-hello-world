package com.quan.rest.webservices.quickreview.post;

public class Post {
    private String postMessage;
    private Integer postId;
    private Integer userId;

    public Post() {
        
    }
    public Post(String postMessage, Integer postId, Integer userId) {
        this.postId=postId;
        this.postMessage=postMessage;
        this.userId=userId;
    }
    public Integer getPostId() {
        return postId;
    }
    public void setPostId(Integer postId) {
        this.postId = postId;
    }
    public String getPostMessage() {
        return postMessage;
    }
    public void setPostMessage(String postMessage) {
        this.postMessage = postMessage;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
