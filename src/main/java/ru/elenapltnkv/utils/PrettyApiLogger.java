package ru.elenapltnkv.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.internal.platform.Platform;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;

public class PrettyApiLogger implements HttpLoggingInterceptor.Logger {
    @Override
    public void log(@NotNull String s) {
        String massage= s.trim();
        ObjectMapper mapper = new ObjectMapper();
        if (massage.startsWith("{") && (massage.endsWith("}")) || massage.startsWith("[") && massage.endsWith("]")) {
            massage = s;
            try {
                Object value = mapper.readValue(massage, Object.class);
                String prettyJsonValue = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(value);
                Platform.get().log(prettyJsonValue, Platform.INFO, null);

            } catch (JsonProcessingException e) {
                Platform.get().log(massage, Platform.WARN, e);
                throw new RuntimeException(e);
            }
        } else {
            Platform.get().log(massage, Platform.INFO, null);
        }
    }
    //1:36
}
