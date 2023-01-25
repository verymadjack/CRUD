package com.example.crud2;

public class Computer {
    private String name;
    private String year;
    private String needsFixing;
    public Computer(){}
    public Computer(String name, String year, String needsFixing) {
        this.name = name;
        this.year = year;
        this.needsFixing = needsFixing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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
}
