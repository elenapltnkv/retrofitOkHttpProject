package ru.elenapltnkv.services;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.*;
import ru.elenapltnkv.dao.*;

import static ru.elenapltnkv.utils.Endpoints.GET_USER_ID;
import static ru.elenapltnkv.utils.Endpoints.USERS_ID;


public interface UserService {
    @POST(USERS_ID)
    Call<NUserRes> postAddNewUser(@Body NewUser user);

    ///api/users/2
    @GET(USERS_ID)
    Call<UsersPage> getUsers(@Query("page") int currentPage);

    @GET(USERS_ID)
    Call<GetUserNegativePage> getNegativeUsers(@Query("page") int currentPage);

    @GET(GET_USER_ID+"{id}")
    Call<Users> getSingleUser(@Path("id") int id);

    @DELETE(USERS_ID+"{id}")
    Call<Users> deleteUser(@Path("id") int id);

}




