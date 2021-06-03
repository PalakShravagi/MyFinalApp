package com.example.e_assess;

public class model {
    String name;

    public model() {

    }

    public model( String name) {

        this.name = "Prof. " + name;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = "Prof. " + name;
    }

}
