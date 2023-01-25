package com.example.crud2;

public class Position {
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

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

    public void setSalary(String position) {
        this.salary = salary;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String age) {
        this.hours = hours;
    }
}
