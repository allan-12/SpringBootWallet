package com.example.springwallet.connection;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Component
public class DatabaseConfig {
    @Bean
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                Config.URL,
                Config.USERNAME,
                Config.PASSWORD
        );
    }
}
