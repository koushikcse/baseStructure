package com.basestructure.network;

import android.content.Context;
import android.os.Build;

import com.basestructure.BuildConfig;
import com.basestructure.R;
import com.basestructure.shared.Constants;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class TokenInterceptor implements Interceptor {
    private Context context;
    private String authStr = "";
    private String SESSIONID = "";
    private TokenHandler tokenHandler;

    TokenInterceptor(Context context) {
        this.context = context;
        tokenHandler = new TokenHandler(context);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        // Set auth token
        if (authStr.isEmpty()) {
            String authToken = tokenHandler.getAccessToken();
            if (authToken != null) {
                authStr = authToken;
            }
        }

        if (authStr == null || authStr.isEmpty()) {
            if (!Constants.PHPSESSID.equals("")) {
                SESSIONID = Constants.PHPSESSID + "; path=/";
            }
        } else {
            authStr += "; " + Constants.PHPSESSID;
        }


        String user_agent = context.getString(R.string.app_name) + "/" + BuildConfig.VERSION_NAME
                + "." + BuildConfig.VERSION_CODE + " (" + Build.MODEL + "; Android/" + Build.VERSION.RELEASE + ")";

        Request request = chain.request();
        Request.Builder requestBuilder = request.newBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("User-Agent", user_agent);

        if (!authStr.isEmpty()) {
            requestBuilder.addHeader("Cookie", authStr);
        } else if (!SESSIONID.isEmpty()) {
            requestBuilder.addHeader("Cookie", SESSIONID);
        }

        request = requestBuilder.build();
        Response response = chain.proceed(request);

        String cookies = response.header("Set-Cookie");

        if (Constants.PHPSESSID.equals("") && cookies.contains("PHPSESSID")) {
            String[] temp = cookies.split(";");
            for (String str : temp) {
                if (str.contains("PHPSESSID")) {
                    Constants.PHPSESSID = str;
                    break;
                }
            }
        } else if (authStr == null || authStr.isEmpty()) {
            try {
                String responseString = ParseUtils.getResponseAsString(response);
                response = cloneResponse(response, responseString);
                // Storing Session
                if (cookies != null) {
                    tokenHandler.saveAccessToken(cookies);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return response;
    }

    private Response cloneResponse(Response response, String content) {
        ResponseBody responseBody = ResponseBody.create(response.body().contentType(), content);
        return response.newBuilder().body(responseBody).build();
    }

}
