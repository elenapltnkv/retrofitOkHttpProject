package ru.elenapltnkv.tests;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import ru.elenapltnkv.dao.NUserRes;
import ru.elenapltnkv.dao.NewUser;

import java.io.IOException;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.not;


public class PostPositiveUser extends BaseTest {

    NewUser user = new NewUser();
    Integer id;

    @BeforeEach
    void setUp() {
        user.setName(faker.name().firstName());
        user.setJob(faker.job().position());
    }

    @Test
    void createNewUserTest() throws IOException {
        Response<NUserRes> response = userService
                .postAddNewUser(user)
                .execute();
        id = Integer.valueOf(response.body().getId());
        assertThat(response.body().getName()).isEqualTo(user.getName());
        assertThat(response.body().getJob()).isEqualTo(user.getJob());
        assertThat(response.body().getId()).isNotNull();
    }

    @AfterEach
    void tearDown() throws IOException {

        userService.deleteUser(id).execute();

    }
}
