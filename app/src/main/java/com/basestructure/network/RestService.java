package com.basestructure.network;

import android.content.Context;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.basestructure.shared.Constants;

import java.util.concurrent.TimeUnit;

import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RestService {

    protected Context context;
    protected EventBus eventBus;
    protected Retrofit retrofit;
    protected RestInterface restInterface;
    protected OkHttpClient.Builder clientBuilder;
    protected ObjectMapper objectMapper;

    public RestService(Context context, EventBus eventBus) {
        this.context = context;
        this.eventBus = eventBus;


        clientBuilder = new OkHttpClient.Builder();
        clientBuilder.connectTimeout(10, TimeUnit.MINUTES);
        clientBuilder.readTimeout(10, TimeUnit.MINUTES);
        clientBuilder.writeTimeout(10, TimeUnit.MINUTES);

        clientBuilder.addInterceptor(new TokenInterceptor(context));
        clientBuilder.addInterceptor(new UnauthorizedInterceptor(context));

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        clientBuilder.addInterceptor(httpLoggingInterceptor);

        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);

        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.getAPIURL())
                .client(clientBuilder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .build();

        restInterface = retrofit.create(RestInterface.class);

    }

    public int reBuild() {
        try {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.getAPIURL())
                    .client(clientBuilder.build())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                    .build();

            restInterface = retrofit.create(RestInterface.class);
            return 0;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return 1;
        }
    }
}
