package com.example.crud2;

import com.google.firebase.database.Exclude;

import java.io.Serializable;

public class Position implements Serializable {

    @Exclude
    private String key;
    private String name;
    private String salary;
    private String hours;
    public Position(){}
    public Position(String name, String salary, String hours) {
        this.name = name;
        this.salary = salary;
        this.hours = hours;
    }

    public String getPosName() {
        return name;
    }

    public void setPosName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


}
