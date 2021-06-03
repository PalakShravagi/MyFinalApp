package com.example.e_assess;

import java.util.Map;

public class moduleGroups {
   private String code;
    private Map<String ,Groupno> groups;
    private String name ;
    private String post;

    public moduleGroups() {
    }

    public moduleGroups(String code, Map<String, Groupno> groups, String name, String post) {
        this.code = code;
        this.groups = groups;
        this.name = name;
        this.post = post;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Map<String, Groupno> getGroups() {
        return groups;
    }

    public void setGroups(Map<String, Groupno> groups) {
        this.groups = groups;
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
