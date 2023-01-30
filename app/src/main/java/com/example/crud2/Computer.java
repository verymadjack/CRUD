package com.example.crud2;

import com.google.firebase.database.Exclude;

import java.io.Serializable;

public class Computer implements Serializable {
    @Exclude
    private String key;
    private String name;
    private String year;
    private String needsFixing;
    public Computer(){}
    public Computer(String name, String year, String needsFixing) {
        this.name = name;
        this.year = year;
        this.needsFixing = needsFixing;
    }

    public String getComName() {
        return name;
    }

    public void setComName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getNeedsFixing() {
        return needsFixing;
    }

    public void setNeedsFixing(String needsFixing) {
        this.needsFixing = needsFixing;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
