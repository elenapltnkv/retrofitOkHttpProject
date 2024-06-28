package ru.elenapltnkv.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NUserRes2 {
    public NUserRes2(String name, String job, String id, String createdAt) {
        this.name = name;
        this.job = job;
        this.id = id;
        this.createdAt = createdAt;
    }

        @JsonProperty("name")
        private String name;
        @JsonProperty("job")
        private String job;
        @JsonProperty("id")
        private String id;
        @JsonProperty("createdAt")
        private String createdAt;
}
