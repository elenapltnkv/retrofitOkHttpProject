package ru.elenapltnkv.services;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.*;
import ru.elenapltnkv.dao.NUserRes;
import ru.elenapltnkv.dao.NewUser;
import ru.elenapltnkv.dao.Users;
import ru.elenapltnkv.dao.UsersPage;


public interface UserService {
    @POST("/api/users")
    Call<NUserRes> postAddNewUser(@Body NewUser user);

    ///api/users/2
    @GET("/api/users")
    Call<UsersPage> getUsers(@Query("page") int currentPage);

    @GET("/api/users/{id}")
    Call<Users> getSingleUser(@Path("id") int id);

    @DELETE("/api/users/{id}")
    Call<Users> deleteUser(@Path("id") int id);

}




