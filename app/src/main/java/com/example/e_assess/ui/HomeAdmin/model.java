package com.example.e_assess.ui.HomeAdmin;

public class model {
    String name ,uerid;

    public model() {

    }

    public model(String name) {
        this.name = "Prof. "+ name;
    }

    public model(String name, String uerid) {
        this.name = "Prof. "+name;
        this.uerid = uerid;
    }

    public String getUerid() {
        return uerid;
    }

    public void setUerid(String uerid) {
        this.uerid = uerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = "Prof. " + name;
    }

}
