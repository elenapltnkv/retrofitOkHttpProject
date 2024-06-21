package ru.elenapltnkv.tests;

import okhttp3.ResponseBody;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import ru.elenapltnkv.dao.Pet.Pet;
import ru.elenapltnkv.services.PetService;
import ru.elenapltnkv.utils.RetrofitUtils;

import java.io.IOException;

public class PetTest {
    //https://petstore.swagger.io/#/


    static Retrofit retrofit;
    static PetService petService;

    @BeforeAll
    static void beforeAll() {
        retrofit= RetrofitUtils.getRetrofit();
        petService = retrofit.create(PetService.class);
    }

    @Test
    void postAddNewPetInShop() throws IOException {
        //Response<ResponseBody> response = petService.postAddNewPet().execute();
        //System.out.println(response.errorBody().string());

    }

    @Test
    void getPetId() throws IOException {
        Response<ResponseBody> response = petService.getPetById(1).execute();
//        try {
//            System.out.println(response.body().string());
//        } catch (NullPointerException e) {
//            System.out.println(response.errorBody().string());
//        }
        //System.out.println(response.body().string());

    }

}
