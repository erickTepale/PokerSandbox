package com.pokersandbox.PokerSandbox.models.dao;

public class EmailValidatorAPI {
    private String email;
    private String did_you_mean;
    private String user;
    private String domain;
    private Boolean format_valid;
    private Boolean mx_found;
    private Boolean smtp;
    private Boolean catch_all;
    private Boolean role;
    private Boolean disposable;
    private Boolean free;
    private String score;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDid_you_mean() {
        return did_you_mean;
    }

    public void setDid_you_mean(String did_you_mean) {
        this.did_you_mean = did_you_mean;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Boolean getFormat_valid() {
        return format_valid;
    }

    public void setFormat_valid(Boolean format_valid) {
        this.format_valid = format_valid;
    }

    public Boolean getMx_found() {
        return mx_found;
    }

    public void setMx_found(Boolean mx_found) {
        this.mx_found = mx_found;
    }

    public Boolean getSmtp() {
        return smtp;
    }

    public void setSmtp(Boolean smtp) {
        this.smtp = smtp;
    }

    public Boolean getCatch_all() {
        return catch_all;
    }

    public void setCatch_all(Boolean catch_all) {
        this.catch_all = catch_all;
    }

    public Boolean getRole() {
        return role;
    }

    public void setRole(Boolean role) {
        this.role = role;
    }

    public Boolean getDisposable() {
        return disposable;
    }

    public void setDisposable(Boolean disposable) {
        this.disposable = disposable;
    }

    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "EmailValidatorAPI{" +
                "email='" + email + '\'' +
                ", did_you_mean='" + did_you_mean + '\'' +
                ", user='" + user + '\'' +
                ", domain='" + domain + '\'' +
                ", format_valid=" + format_valid +
                ", mx_found=" + mx_found +
                ", smtp=" + smtp +
                ", catch_all=" + catch_all +
                ", role=" + role +
                ", disposable=" + disposable +
                ", free=" + free +
                ", score='" + score + '\'' +
                '}';
    }
}
