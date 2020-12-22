package com.quan.rest.webservices.quickreview.user;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.quan.rest.webservices.quickreview.post.Post;

public class User {
    private Integer id;
    @Size(min = 2, message = "name must have at least 2 characters")
    private String name;

    @Past
    private Date birthDate;
    private List<Post> posts;
    protected User(){

    }
    public  User(Integer id,String name,Date birthDay,List<Post>posts) {
        super();
        this.id=id;
        this.name=name;
        this.birthDate=birthDay;
        this.posts=posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
    public List<Post> getPosts() {
        return posts;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return String.format("user [id=%s,name=%s,birthday=%s", id,name,birthDate);
    }
}
