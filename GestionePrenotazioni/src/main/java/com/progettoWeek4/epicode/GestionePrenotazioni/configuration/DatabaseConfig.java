package com.progettoWeek4.epicode.GestionePrenotazioni.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Value("${spring.datasource.username}")
    private String dataSourceUsername;

    @Value("${spring.datasource.password}")
    private String dataSourcePassword;

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url(dataSourceUrl)
                .username(dataSourceUsername)
                .password(dataSourcePassword)
                .build();
    }
}

