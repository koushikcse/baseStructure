package com.basestructure.network;

import android.content.Context;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


public class UnauthorizedInterceptor implements Interceptor {

    private Context context;

    UnauthorizedInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        /*if (response.code() == Constants.UNAUTHORIZED_STATUS_CODE) {
            *//*UserDataStore userDataStore = new UserDataStore(context);
            userDataStore.deleteUserFromFile();*//*
            context.startActivity(new Intent(context, LoginActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
            Toast.makeText(context, R.string.session_expired_msg, Toast.LENGTH_SHORT).show();
        }*/
        return response;
    }
}
