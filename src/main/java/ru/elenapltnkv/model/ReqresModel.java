package ru.elenapltnkv.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import okhttp3.*;
import ru.elenapltnkv.dao.NUserRes2;
import ru.elenapltnkv.dao.NewUser;
import ru.elenapltnkv.db.BaseInfo;
import ru.elenapltnkv.db.DataBaseRepoitory;
import ru.elenapltnkv.db.User;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;


public class ReqresModel extends BaseInfo {
    static OkHttpClient okHttpClient = new OkHttpClient();
    static ObjectMapper objectMapper = new ObjectMapper();

    public static void getUsersPageTwo() throws IOException {

        HttpUrl url = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_URL)
                .addPathSegment(PART_URL)
                .addQueryParameter(QUERRY_PARAM, "2")
                .build();
        String s = String.valueOf(url);
        String url_decode = URLDecoder.decode(s.replace("\\x", "%"), StandardCharsets.UTF_8);

        Request request = new Request.Builder()
                .url(url_decode)
                .get()
                .build();
        Response response = okHttpClient.newCall(request).execute();

        String responseBody = response.body().string();
        User.Data user;
        for (int i = 0; i < 6; i++) {
            String email = objectMapper.readTree(responseBody).at("/data").get(i).at("/email").asText();
            String first_name = objectMapper.readTree(responseBody).at("/data").get(i).at("/first_name").asText();
            String last_name = objectMapper.readTree(responseBody).at("/data").get(i).at("/last_name").asText();
            String avatar = objectMapper.readTree(responseBody).at("/data").get(i).at("/avatar").asText();


            System.out.println(email + " " + first_name + " " + last_name + " " + avatar);
            user = new User.Data(email, first_name, last_name, avatar);

            DataBaseRepoitory dataBaseRepoitory = new DataBaseRepoitory();
            dataBaseRepoitory.saveUser(user);
        }
    }

    public static void postCreateNewUser() throws IOException {
        Faker faker = new Faker();
        NewUser user = new NewUser();

        user.setName(faker.name().firstName());
        user.setJob(faker.job().position());

        HttpUrl url = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_URL)
                .addPathSegment(PART_URL)
                .build();
        String s = String.valueOf(url);
        String url_decode = URLDecoder.decode(s.replace("\\x", "%"), StandardCharsets.UTF_8);

        RequestBody formBody = new FormBody.Builder()
                .add("name", user.getName())
                .add("job", user.getJob())
                .build();
        Request request = new Request.Builder()
                .url(url_decode)
                .post(formBody)
                .build();
        Response response = okHttpClient.newCall(request).execute();
        String responseBody = response.body().string();

        String name = objectMapper.readTree(responseBody).at("/name").asText();
        String job = objectMapper.readTree(responseBody).at("/job").asText();
        String id = objectMapper.readTree(responseBody).at("/id").asText();
        String createdAt = objectMapper.readTree(responseBody).at("/createdAt").asText();

        NUserRes2 ures;// = new NUserRes()
        System.out.println(name + " " + job + " " + id + " " + createdAt);
        ures = new NUserRes2(name, job, id, createdAt);

        DataBaseRepoitory dataBaseRepoitory = new DataBaseRepoitory();
        dataBaseRepoitory.saveNewUser(ures);


    }

    public static void main(String[] args) throws IOException {
        postCreateNewUser();
    }

}


