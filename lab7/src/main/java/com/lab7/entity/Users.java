package com.lab7.entity;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column(unique = true, nullable = false)
    private String authToken;
    @Column(unique = true, nullable = false)
    public String userName;
    @Column(nullable = false)
    private String positionOnStarship;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private String sex;
    @Column(nullable = false)
    private int balance;
    @Column(nullable = false)
    private String background;
    @Column(nullable = false)
    private String publicBackground;
    @Column(nullable = false)
    private String photo;
    @Column(nullable = false)
    private String securityBackground;
    @Column(nullable = false)
    private String medicalBackground;
    @Column(nullable = false)
    private String psychologyBackground;
    @Column(nullable = false)
    private int lastAvailable;
    @Column(nullable = false)
    private int userSettings;
    @Column
    private boolean is_active;

    public boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPositionOnStarship() {
        return positionOnStarship;
    }

    public void setPositionOnStarship(String positionOnStarship) {
        this.positionOnStarship = positionOnStarship;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getPublicBackground() {
        return publicBackground;
    }

    public void setPublicBackground(String publicBackground) {
        this.publicBackground = publicBackground;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSecurityBackground() {
        return securityBackground;
    }

    public void setSecurityBackground(String securityBackground) {
        this.securityBackground = securityBackground;
    }

    public String getMedicalBackground() {
        return medicalBackground;
    }

    public void setMedicalBackground(String medicalBackground) {
        this.medicalBackground = medicalBackground;
    }

    public String getPsychologyBackground() {
        return psychologyBackground;
    }

    public void setPsychologyBackground(String psychologyBackground) {
        this.psychologyBackground = psychologyBackground;
    }

    public int getLastAvailable() {
        return lastAvailable;
    }

    public void setLastAvailable(int lastAvailable) {
        this.lastAvailable = lastAvailable;
    }

    public int getUserSettings() {
        return userSettings;
    }

    public void setUserSettings(int userSettings) {
        this.userSettings = userSettings;
    }
}
