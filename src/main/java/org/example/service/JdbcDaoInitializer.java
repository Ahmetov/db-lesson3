package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class JdbcDaoInitializer {
    private static Connection connection;

    @Autowired
    ApplicationContext context;

    @Value("${db.connection}")
    private static String URL;

    @Value("${db.user}")
    private static String USER;

    @Value("${db.password}")
    private static String PASSWORD;

    //Инициализация коннекта к базе
    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sweetdb",
                    "postgres",
                    "root"
            );
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    //Чтение и выполнение sql файла в ресурсах
    @PostConstruct
    public void init() {
        Resource resource = context.getResource("classpath:data.sql");
        ScriptUtils.executeSqlScript(connection, resource);
    }

    public static Connection getConnection() {
        return connection;
    }
}
