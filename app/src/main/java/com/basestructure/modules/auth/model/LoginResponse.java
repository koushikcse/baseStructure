package com.basestructure.modules.auth.model;

import com.basestructure.network.ServerResponse.MainServerResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by innofied on 29/3/18.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResponse extends MainServerResponse implements Serializable {
    @JsonProperty("email")
    private String email;
    @JsonProperty("fname")
    private String fname;
    @JsonProperty("lname")
    private String lname;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}
