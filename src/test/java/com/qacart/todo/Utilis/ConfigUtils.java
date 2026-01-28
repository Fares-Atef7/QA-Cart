package com.qacart.todo.Utilis;

import java.util.Properties;

public class ConfigUtils {
    private Properties properties;
    private static ConfigUtils configUtils;

//    public ConfigUtils() {
//        String env = System.getProperty("env", "production");
//        switch (env) {
//            case "PRODUCTION":
//                properties = PropertiesUtils.loadProperties("src/test/java/com/qacart/todo/config/production.properties");
//                break;
//            case "LOCAL":
//                properties=PropertiesUtils.loadProperties("src/test/java/com/qacart/todo/config/local.properties");
//                break;
//            default:
//                throw new RuntimeException("invalid input");
//        }
//    }

    public static ConfigUtils getInstance() {
        if (configUtils == null) {
            configUtils = new ConfigUtils();
        }
        return configUtils;
    }

    public String getBaseUrl() {
//        String baseUrl = properties.getProperty("baseUrl");
        properties = PropertiesUtils.loadProperties("src/test/java/com/qacart/todo/config/production.properties");
        String baseUrl = properties.getProperty("baseUrl");
        if (baseUrl != null) return baseUrl;
        throw new RuntimeException("could not find the Base Url");
    }

    public String getemail() {
        String baseUrl = properties.getProperty("email");
        if (baseUrl != null) return baseUrl;
        throw new RuntimeException("could not find the email");
    }

    public String getPassword() {
        String baseUrl = properties.getProperty("password");
        if (baseUrl != null) return baseUrl;
        throw new RuntimeException("could not find the password");
    }

}
