package com.basestructure.socialIntegration.facebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;


public class FacebookIntegration implements FacebookCallback<LoginResult>,
        GraphRequest.GraphJSONObjectCallback {

    private CallbackManager callbackManager;
    private LoginManager loginManager;
    private Activity activity;
    private FacebookListener facebookListener;

    FacebookIntegration(Activity activity) {
        callbackManager = CallbackManager.Factory.create();
        loginManager = LoginManager.getInstance();
        this.activity = activity;
    }

    public static FacebookIntegration create(Activity activity) {
        return new FacebookIntegration(activity);
    }

    public void facebookLogin() {
        loginManager.logInWithReadPermissions(activity, Arrays.asList("public_profile", "email"));
        loginManager.registerCallback(callbackManager, this);
    }

    public void setFacebookListener(FacebookListener facebookListener) {
        this.facebookListener = facebookListener;
    }

    public void onActivityResultCall(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onSuccess(LoginResult loginResult) {
        GraphRequest graphRequest = GraphRequest.newMeRequest(loginResult.getAccessToken(), this);
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,email,first_name,last_name");
        graphRequest.setParameters(parameters);
        graphRequest.executeAsync();
    }

    @Override
    public void onCancel() {
        facebookListener.onFacebookLoginCancel();
    }

    @Override
    public void onError(FacebookException error) {
        facebookListener.onFacebookLoginError();
    }

    @Override
    public void onCompleted(final JSONObject object, GraphResponse response) {
        Profile profile = Profile.getCurrentProfile();
        final int imageDimesions = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                60, activity.getResources().getDisplayMetrics());
        if (profile != null) {
            SocialUser socialUser = new SocialUser();
            try {
                socialUser.setEmail(object.getString("email"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            socialUser.setName(profile.getName());
            socialUser.setFname(profile.getFirstName());
            socialUser.setLname(profile.getLastName());
            socialUser.setSocialImgUri(String.valueOf(
                    profile.getProfilePictureUri(imageDimesions, imageDimesions)));
            socialUser.setFacebookId(profile.getId());
            if (facebookListener != null) {
                facebookListener.sendFacebookData(socialUser);
            }
        } else {
            ProfileTracker profileTracker = new ProfileTracker() {
                @Override
                protected void onCurrentProfileChanged(Profile oldProfile, Profile newProfile) {
                    SocialUser socialUser = new SocialUser();
                    try {
                        socialUser.setEmail(object.getString("email"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    socialUser.setName(newProfile.getName());
                    socialUser.setFname(newProfile.getFirstName());
                    socialUser.setLname(newProfile.getLastName());
                    socialUser.setSocialImgUri(String.valueOf(
                            newProfile.getProfilePictureUri(imageDimesions, imageDimesions)));
                    socialUser.setFacebookId(newProfile.getId());
                    if (facebookListener != null) {
                        facebookListener.sendFacebookData(socialUser);
                    }
                    stopTracking();
                }
            };
            profileTracker.startTracking();
        }
    }

    public interface FacebookListener {
        void sendFacebookData(SocialUser socialUser);

        void onFacebookLoginCancel();

        void onFacebookLoginError();
    }

    public void facebookLogout() {
        loginManager.getInstance().logOut();
    }


}
