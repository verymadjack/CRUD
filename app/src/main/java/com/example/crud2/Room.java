package com.example.crud2;

public class Room {
    private String number;
    private String hasWiFi;
    private String isSecured;
    public Room(){}
    public Room(String number, String hasWiFi, String isSecured) {
        this.number = number;
        this.hasWiFi = hasWiFi;
        this.isSecured = isSecured;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getHasWiFi() {
        return hasWiFi;
    }

    public void setHasWiFi(String hasWiFi) {
        this.hasWiFi = hasWiFi;
    }

    public String getIsSecured() {
        return isSecured;
    }

    public void setIsSecured(String isSecured) {
        this.isSecured = isSecured;
    }
}
