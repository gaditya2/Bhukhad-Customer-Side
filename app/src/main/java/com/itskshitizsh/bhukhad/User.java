package com.itskshitizsh.bhukhad;

public class User {

    private String Name;
    private String RollNo;
    private String PhoneNo;
    private String Password;

    public User() {
    }

    public User(String name, String phoneNo, String password) {
        Name = name;
        PhoneNo = phoneNo;
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRollNo() {
        return RollNo;
    }

    public void setRollNo(String rollNo) {
        RollNo = rollNo;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}