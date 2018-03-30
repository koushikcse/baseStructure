package com.basestructure.socialIntegration.facebook;

import java.io.Serializable;


public class SocialUser implements Serializable{
    private String email,name, socialImgUri,facebookId,googlePlusId,fname,lname;
    private int socialType;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSocialImgUri() {
        return socialImgUri;
    }

    public void setSocialImgUri(String socialImgUri) {
        this.socialImgUri = socialImgUri;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
        socialType = 1;
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

    public String getGooglePlusId() {
        return googlePlusId;
    }

    public void setGooglePlusId(String googlePlusId) {
        this.googlePlusId = googlePlusId;
        socialType = 2;

    }

    public int getSocialType() {
        return socialType;
    }

    public void setSocialType(int socialType) {
        this.socialType = socialType;
    }
}
