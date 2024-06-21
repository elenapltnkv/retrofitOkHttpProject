package ru.elenapltnkv.services;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.*;
import ru.elenapltnkv.dao.Pet.Pet;

public interface PetService {
    @POST("/pet")
    Call<Pet> postAddNewPet(@Body Pet pet);

    @GET("pet/{id}")
    Call<ResponseBody> getPetById(@Path("id") int id);

    @DELETE("/pet/{id}")
    Call<Pet> deletePet(@Path("id") int id, @Body Pet pet);

}




