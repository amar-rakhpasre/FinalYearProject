package com.example.finalyearproject.java;

public class UserModel {
    private String name;
    private String email;
    private String number;
    private String password;
    private int isUser; // 1 for regular user, 0 for not a regular user
    public int isAdmin; // 1 for admin user, 0 for not an admin user


    public UserModel() {
        // Default constructor required for Firebase
    }

    public UserModel(String name, String email, String number, String password) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.password = password;
        this.isUser = 1; // Set isUser to 1 for new user
        this.isAdmin = 1; // Set isUser to 1 for new user
    }

    // Add getters and setters for all fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getters and setters for all fields
    // ...

    public int getIsUser() {
        return isUser;
    }

    public void setIsUser(int isUser) {
        this.isUser = isUser;
    }

    public int getIsAdmin() {
        return 0;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }
}