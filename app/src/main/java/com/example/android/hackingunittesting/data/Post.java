package com.example.android.hackingunittesting.data;

/**
 * Created by pranit on 1/7/17.
 */

public class Post {
    private Integer userId;

    private Integer id;

    private String title;

    private String body;

    public Post(String title, String body){
        this.title = title;
        this.body = body;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
