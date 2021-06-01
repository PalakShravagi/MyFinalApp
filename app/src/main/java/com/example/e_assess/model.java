package com.example.e_assess;

public class model {
    String code,name,post;

    public model() {

    }

    public model(String code, String name, String post) {
        this.code = code;
        this.name = name;
        this.post = post;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
