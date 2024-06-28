package ru.elenapltnkv.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import ru.elenapltnkv.dao.NUserRes;
import ru.elenapltnkv.dao.NUserRes2;
import ru.elenapltnkv.dao.NewUser;
import ru.elenapltnkv.db.DataBaseRepoitory;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class PostPositiveAdUserDBTest extends BaseTest {

    NewUser user = new NewUser();
    NUserRes2 ures;
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
        assertThat(response.body().getName()).isEqualTo(user.getName());
        assertThat(response.body().getJob()).isEqualTo(user.getJob());
        assertThat(response.body().getId()).isNotNull();

        String name = response.body().getName();
        String job = response.body().getJob();
        String id = response.body().getId();
        String createdAt = response.body().getCreatedAt();

        ures = new NUserRes2(name, job, id, createdAt);

        DataBaseRepoitory dataBaseRepoitory = new DataBaseRepoitory();
        dataBaseRepoitory.saveNewUser(ures);
        assertThat(response.body().getId()).isEqualTo(dataBaseRepoitory.selectUser(id));
        dataBaseRepoitory.selectUser(id);


    }


}
