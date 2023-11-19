package com.epam.webapphello.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final Config INSTANCE = new Config();
    public final static String DB_CONNECTION_STRING = "db-connection-string";

    private Properties properties;

    public Config() {
        try (InputStream inputStream = this.getClass().getResourceAsStream("config.properties")) {
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Config getInstance() {
        return INSTANCE;
    }

    public String read(String name) {
        return (String) properties.get(name);
    }


}
