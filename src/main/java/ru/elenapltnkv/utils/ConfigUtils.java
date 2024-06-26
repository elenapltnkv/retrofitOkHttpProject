package ru.elenapltnkv.utils;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {
    static Properties properties = new Properties();
    private static InputStream configFile;

    static {
        try {
            configFile = new
                    FileInputStream("/home/user/IdeaProjects/retrofitOkHttpProject/src/main/resources/application.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    public static String getBaseUrl() {
        properties.load(configFile);
        return properties.getProperty("URL");
    }
}
