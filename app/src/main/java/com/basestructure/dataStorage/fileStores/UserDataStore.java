package com.basestructure.dataStorage.fileStores;

import android.content.Context;

import com.basestructure.modules.auth.model.LoginResponse;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UserDataStore {
    private static final String INITIAL_USER_FILE = "initial_user_file";

    private Context context;

    public UserDataStore(Context context) {
        this.context = context;
    }

    public void writeInitialUserDataToFile(LoginResponse loginResponse) {
        try {
            FileOutputStream fos = context.openFileOutput(INITIAL_USER_FILE, Context.MODE_PRIVATE);
            ObjectOutputStream ous = new ObjectOutputStream(fos);
            ous.writeObject(loginResponse);
            ous.flush();
            ous.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public LoginResponse getInitialUserDataFromFile() {
        try {
            FileInputStream fis = context.openFileInput(INITIAL_USER_FILE);
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (LoginResponse) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteInitialUserDataFromFile() {
        context.deleteFile(INITIAL_USER_FILE);
    }
}
