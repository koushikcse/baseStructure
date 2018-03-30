package com.basestructure.modules.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.realm.RealmObject;

/**
 * Created by innofied on 30/3/18.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Profile extends RealmObject {
    @JsonProperty("profile_pic")
    private String profile_pic;
    @JsonProperty("phone")
    private String phone;

    @JsonProperty("email")
    private String email;


    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
