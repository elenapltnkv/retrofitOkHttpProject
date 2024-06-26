package ru.elenapltnkv.utils;

import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitUtils {
    static HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new PrettyApiLogger());


    static OkHttpClient client = new OkHttpClient().newBuilder()
            .addInterceptor(logging.setLevel(HttpLoggingInterceptor.Level.BODY))
            .build();

    public static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(ConfigUtils.getBaseUrl())
                .client(client)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

}
