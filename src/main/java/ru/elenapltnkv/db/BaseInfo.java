package ru.elenapltnkv.db;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import okhttp3.OkHttpClient;

public class BaseInfo {
    protected static final String PROTOCOL = "https";
    protected static final String BASE_URL = "reqres.in";
    protected static final String PART_URL = "api/users";
    protected static final String QUERRY_PARAM = "page";

}
