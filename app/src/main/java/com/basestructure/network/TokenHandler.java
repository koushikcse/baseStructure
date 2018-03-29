package com.basestructure.network;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class TokenHandler {
    private static final String FILENAME = "token";

    private Context context;

    public TokenHandler(Context context) {
        this.context = context;
    }

    public void saveAccessToken(String accessToken) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(FILENAME, Context.MODE_PRIVATE));
            outputStreamWriter.write(accessToken);
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getAccessToken() {

        String value = "";

        try {
            InputStream inputStream = context.openFileInput(FILENAME);

            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ((receiveString = bufferedReader.readLine()) != null) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                value = stringBuilder.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //int len = accessTokenBuilder.length();

        /*String fakeToken = accessTokenBuilder.toString();

        accessTokenBuilder.delete(0, len);
        accessTokenBuilder.append(fakeToken);

        len = accessTokenBuilder.length();

        fakeToken = accessTokenBuilder.reverse().toString();
        accessTokenBuilder.delete(0, len);*/

        /*for (int i = 0; i < len; i++) {
            int charAsInt = fakeToken.charAt(i);
            charAsInt -= (len - i) * (i % 4);
            accessTokenBuilder.append((char) charAsInt);
        }*/

        return value;
    }

    public void removeAccessToken() {

        File file = new File(context.getFilesDir(), FILENAME);
        if (file.exists()) {
            file.delete();
        }
    }
}
