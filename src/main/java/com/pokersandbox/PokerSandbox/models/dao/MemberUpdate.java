package com.pokersandbox.PokerSandbox.models.dao;

public class MemberUpdate {

    private String username;
    private String email;
    private String state;
    private String country;

    public MemberUpdate() {
    }

    public MemberUpdate(String username, String email, String state, String country) {
        this.username = username;
        this.email = email;
        this.state = state;
        this.country = country;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
