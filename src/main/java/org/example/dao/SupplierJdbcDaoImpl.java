package org.example.dao;

import org.example.model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class SupplierJdbcDaoImpl implements SupplierJdbcDao{
    private static Connection connection;

    @Autowired
    ApplicationContext context;

    @Value("${db.connection}")
    private static String URL;

    @Value("${db.user}")
    private static String USER;

    @Value("${db.password}")
    private static String PASSWORD;


    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void init() {
        Resource resource = context.getResource("classpath:data.sql");
        ScriptUtils.executeSqlScript(connection, resource);
    }

    @Override
    public List<Owner> findAll() {
        List<Owner> owners = new ArrayList<>();
        try {
            String SQL = "select * from owner";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                Owner owner = new Owner();

            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public void save(Owner owner) {

    }

    @Override
    public void update(Owner owner) {

    }

    @Override
    public void remove(Owner owner) {

    }
}
