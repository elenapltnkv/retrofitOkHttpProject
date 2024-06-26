package ru.elenapltnkv.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import retrofit2.Retrofit;
import ru.elenapltnkv.services.UserService;
import ru.elenapltnkv.utils.RetrofitUtils;

public class BaseTest {
    static Retrofit retrofit;
    static UserService userService;
    static Faker faker;

    @BeforeAll
    static void beforeAll() {
        retrofit = RetrofitUtils.getRetrofit();
        userService = retrofit.create(UserService.class);
        faker= new Faker();
    }
}
