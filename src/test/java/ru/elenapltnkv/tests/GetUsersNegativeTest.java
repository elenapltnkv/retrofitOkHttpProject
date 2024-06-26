package ru.elenapltnkv.tests;

import org.junit.jupiter.api.Test;
import retrofit2.Response;
import ru.elenapltnkv.dao.GetUserNegativePage;
import ru.elenapltnkv.dao.Users;
import ru.elenapltnkv.dao.UsersPage;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static ru.elenapltnkv.utils.ExResult.GET_WRONG_PAGE;

public class GetUsersNegativeTest extends BaseTest {

    @Test
    void getUsers() throws IOException {

        Response<GetUserNegativePage> response = userService

                .getNegativeUsers(152)
                .execute();

        assertThat(response.body().getSupport().getText()).isEqualTo(GET_WRONG_PAGE);



    }

    @Test
    void getSinglUser() throws IOException {

        Response<Users> response = userService

                .getSingleUser(777)
                .execute();

        assertThat(response.body()).isNull();

    }
}
