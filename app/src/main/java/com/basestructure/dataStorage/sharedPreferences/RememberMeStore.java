package com.basestructure.dataStorage.sharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

public class RememberMeStore {
    private Context context;
    private static final String REMEMBERME_FILE = "rememberme_file";

    @Inject
    public RememberMeStore(Context context) {
        this.context = context;
    }

    public void saveRememberMeUser(boolean rememberme,String username, String password) {
        SharedPreferences.Editor sharedPreferenceEditor = context.getSharedPreferences(
                REMEMBERME_FILE, Context.MODE_PRIVATE).edit();
        sharedPreferenceEditor.putBoolean("rememberMe", rememberme);
        sharedPreferenceEditor.putString("username", username);
        sharedPreferenceEditor.putString("password", password);
        sharedPreferenceEditor.apply();

    }

    public boolean getRememberMe(){
        SharedPreferences sharedPreference = context.getSharedPreferences(REMEMBERME_FILE,
                Context.MODE_PRIVATE);
        return sharedPreference.getBoolean("rememberMe", false);
    }

    public String[] getRememberMeUser() {
        SharedPreferences sharedPreference = context.getSharedPreferences(REMEMBERME_FILE,
                Context.MODE_PRIVATE);

        String username = sharedPreference.getString("username", "");
        String password = sharedPreference.getString("password", "");
        return new String[]{username, password};
    }

    public void removeRememberMeUser() {
        SharedPreferences sharedPreference = context.getSharedPreferences(REMEMBERME_FILE, Context.MODE_PRIVATE);
        sharedPreference.edit().clear().apply();
    }
}