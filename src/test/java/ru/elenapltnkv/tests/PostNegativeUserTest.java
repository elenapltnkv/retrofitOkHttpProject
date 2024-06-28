package ru.elenapltnkv.tests;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import ru.elenapltnkv.dao.NUserRes;
import ru.elenapltnkv.dao.NewUser;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class PostNegativeUserTest extends BaseTest {

    NewUser user = new NewUser();
    Integer id;


    @BeforeEach
    void setUp() {
        user.setName(null);
        user.setJob(null);
    }

    @Test
    void createNullUserTest() throws IOException {
        Response<NUserRes> response = userService
                .postAddNewUser(user)
                .execute();

        id = Integer.valueOf(response.body().getId());

        assertThat(response.body().getName()).isNull();
        assertThat(response.code()).isEqualTo(201);

    }

    @Test
    void createNewUserTest() throws IOException {
        Response<NUserRes> response = userService
                .postAddNewUser(user)
                .execute();

        id = Integer.valueOf(response.body().getId());

        assertThat(response.body().getName()).isNull();
        assertThat(response.code()).isEqualTo(201);

    }

    @AfterEach
    void tearDown() throws IOException {

        userService.deleteUser(id).execute();

    }
}
