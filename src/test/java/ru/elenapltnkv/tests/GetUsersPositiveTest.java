package ru.elenapltnkv.tests;

import org.junit.jupiter.api.Test;
import retrofit2.Response;
import ru.elenapltnkv.dao.Users;
import ru.elenapltnkv.dao.UsersPage;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GetUsersPositiveTest extends BaseTest {

    @Test
    void getUsers() throws IOException {

        Response<UsersPage> response = userService

                .getUsers(2)
                .execute();

        assertThat(response.body().getPage().equals(2));
        assertThat(response.body().getData().get(0).getLastName().equals("Lawson"));
        assertThat(response.body().getData().contains("michael.lawson@reqres.in"));


    }

    @Test
    void getSinglUser() throws IOException {

        Response<Users> response = userService

                .getSingleUser(2)
                .execute();

        assertThat(response.body().getData().getEmail().equals("janet.weaver@reqres.in"));

    }
}
