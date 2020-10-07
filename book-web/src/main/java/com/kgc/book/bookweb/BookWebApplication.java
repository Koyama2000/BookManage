package com.kgc.book.bookweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.xml.datatype.DatatypeConfigurationException;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class BookWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookWebApplication.class, args);
    }

}
