package com.farmaciaya.responses;

/**
 * Created by nachogarrone on 13/10/15.
 */
public class LoginResponse {
    String token;
    String firstname;
    String lastname;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
