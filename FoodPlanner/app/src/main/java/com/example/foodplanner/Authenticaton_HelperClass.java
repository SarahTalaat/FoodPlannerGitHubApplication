package com.example.foodplanner;

public class Authenticaton_HelperClass {


    String name  , username , id ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public Authenticaton_HelperClass(String name, String username,String id) {
        this.name = name;
        this.username = username;
        this.id=id;
    }

    public Authenticaton_HelperClass(String name, String username) {
        this.name = name;
        this.username = username;
    }


    public Authenticaton_HelperClass() {
    }




}
