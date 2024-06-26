package ru.elenapltnkv.db;

import lombok.Data;

import java.util.ArrayList;

@Data
public class User {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private ArrayList<Data> data;
    private Support support;

    @lombok.Data
    public static class Data {
        private int id;
        private String email;
        private String first_name;
        private String last_name;
        private String avatar;


        public Data(String email, String first_name, String last_name, String avatar) {
            this.email = email;
            this.first_name = first_name;
            this.last_name = last_name;
            this.avatar = avatar;
        }


    }

    @lombok.Data
    public static class Support {
        private String url;
        private String text;
    }


}
