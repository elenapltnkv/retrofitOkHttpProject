package ru.elenapltnkv.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class UsersPage {

    @JsonProperty("page")
    private Integer page;
    @JsonProperty("per_page")
    private Integer perPage;
    @JsonProperty("total")
    private Integer total;
    @JsonProperty("total_pages")
    private Integer totalPages;
    @JsonProperty("data")
    private List<Data> data;
    @JsonProperty("support")
    private Support support;
    @lombok.Data
    public static class Data {

        @JsonProperty("id")
        private Integer id;
        @JsonProperty("email")
        private String email;
        @JsonProperty("first_name")
        private String firstName;
        @JsonProperty("last_name")
        private String lastName;
        @JsonProperty("avatar")
        private String avatar;

    }
    @lombok.Data
    public static class Support {

        @JsonProperty("url")
        private String url;
        @JsonProperty("text")
        private String text;

    }
}
