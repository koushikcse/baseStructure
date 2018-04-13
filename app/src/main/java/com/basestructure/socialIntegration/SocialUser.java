package com.basestructure.socialIntegration;

/**
 * Created by debanjan on 12/1/17.
 */

import java.io.Serializable;

/**
 * Created by innofied on 22/12/15.
 */
public class SocialUser implements Serializable {
    private String userId;
    private String email;
    private String mobile;
//    @SerializedName("facebooklink")
    private String facebookId;
//    @SerializedName("googlelink")
    private String googlePlusId;
//    @SerializedName("twitterlink")
    private String twitterId;
    private String linkedinId;
//    @SerializedName("profilePicture")
    private String imageUri;
//    @SerializedName("userName")
    private String name;
    private int socialType;

    /* public SocialUser() {
         socialType = 0;
     }
 */
    public int getSocialType() {
        return socialType;
    }

    public void setSocialType(int socialType) {
        this.socialType = socialType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
        socialType = 2;
    }

    public String getGooglePlusId() {
        return googlePlusId;
    }

    public void setGooglePlusId(String googlePlusId) {
        this.googlePlusId = googlePlusId;
        socialType = 3;
    }

    public String getTwitterId() {
        return twitterId;
    }

    public void setTwitterId(String twitterId) {
        this.twitterId = twitterId;
        socialType = 4;
    }

    public String getLinkedinId() {
        return linkedinId;
    }

    public void setLinkedinId(String linkedinId) {
        this.linkedinId = linkedinId;
        socialType = 5;

    }
}