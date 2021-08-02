package com.def.connection;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class InitDatabase {

    private DriverManagerDataSource source;

    public void init(){
        Properties properties = new Properties();

        try {
            source = new DriverManagerDataSource();
            properties.load(new FileInputStream("src/main/resources/database.properties"));
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String pass = properties.getProperty("password");
            String driver = properties.getProperty("driver.class");
            source.setUsername(username);
            source.setPassword(pass);
            source.setUrl(url);
            source.setDriverClassName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   public  DriverManagerDataSource getSource(){
        return source;
    }
}
