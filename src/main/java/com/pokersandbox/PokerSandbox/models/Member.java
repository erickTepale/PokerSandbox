package com.pokersandbox.PokerSandbox.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(unique = true, nullable = false)
    private String email;
    private Long post_count;
    private Long response_count;
    private String state;
    private String country;
    private LocalDate date_registered;

    public Member() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPost_count() {
        return post_count;
    }

    public void setPost_count(Long post_count) {
        this.post_count = post_count;
    }

    public Long getResponse_count() {
        return response_count;
    }

    public void setResponse_count(Long response_count) {
        this.response_count = response_count;
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

    public LocalDate getDate_registered() {
        return date_registered;
    }

    public void setDate_registered(LocalDate date_registered) {
        this.date_registered = date_registered;
    }
}
