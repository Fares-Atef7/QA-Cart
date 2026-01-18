package com.qacart.todo.testcase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Dummyclass {
    public static void main(String[] args) throws IOException {

        File file =new File("src/test/java/com/qacart/todo/config/production.properties");
        InputStream inputStream=new FileInputStream(file);
        Properties properties=new Properties();
        properties.load(inputStream);

        String BaseUrl=properties.getProperty("baseUrl");

        System.out.println(BaseUrl);

    }
}
