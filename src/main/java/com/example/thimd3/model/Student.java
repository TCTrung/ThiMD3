package com.example.thimd3.model;

public class Student {
    private int id;
    private String name;
    private String email;
    private String localDate;
    private String address;
    private int phoneNumber;
    private String classroom;


    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public Student() {
    }

    public Student(String name, String email, String localDate, String address, int phoneNumber, String classroom) {
        this.name = name;
        this.email = email;
        this.localDate = localDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.classroom = classroom;
    }

    public Student(int id, String name, String email, String localDate, String address, int phoneNumber, String classroom) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.localDate = localDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.classroom = classroom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
