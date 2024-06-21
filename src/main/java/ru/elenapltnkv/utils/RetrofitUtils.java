package ru.elenapltnkv.utils;

import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

public class RetrofitUtils {
    static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
    static OkHttpClient client = new OkHttpClient().newBuilder()
            .addInterceptor(loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY))
            .build();

    public static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://petstore.swagger.io/v2/")
                .client(client)
                //.addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

}
