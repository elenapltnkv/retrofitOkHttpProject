package ru.elenapltnkv.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class GetUserNegativePage {
    @JsonProperty("page")
    private Integer page;
    @JsonProperty("per_page")
    private Integer perPage;
    @JsonProperty("total")
    private Integer total;
    @JsonProperty("total_pages")
    private Integer totalPages;
    @JsonProperty("data")
    private List<Object> data;
    @JsonProperty("support")
    private Support support;

    @Data
    public class Support {

        @JsonProperty("url")
        private String url;
        @JsonProperty("text")
        private String text;

    }
}
