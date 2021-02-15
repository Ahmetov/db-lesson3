package org.example.dao;

import org.example.model.Owner;
import org.example.service.JdbcDaoInitializer;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class OwnerJdbcDaoImpl implements OwnerJdbcDao {

    @Override
    public List<Owner> findAll() {
        List<Owner> owners = new ArrayList<>();
        try {
            String SQL = "select * from owner";
            Statement statement = JdbcDaoInitializer.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                Owner owner = fillOwnerFields(resultSet);
                owners.add(owner);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return owners;
    }

    @Override
    public void save(Owner owner) {
        String SQL = "insert into owner (firstname, lastname, phone, email) values (?, ?, ?, ?)";
        try {
            PreparedStatement statement = JdbcDaoInitializer.getConnection().prepareStatement(SQL);
            statement.setString(1, owner.getFirstname());
            statement.setString(2, owner.getLastname());
            statement.setString(3, owner.getPhone());
            statement.setString(4, owner.getEmail());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(Owner owner) {
        String SQL = "update owner set firstname = ?, lastname = ?, phone = ?, email = ? where id = ?";
        try {
            PreparedStatement statement = JdbcDaoInitializer.getConnection().prepareStatement(SQL);
            statement.setString(1, owner.getFirstname());
            statement.setString(2, owner.getLastname());
            statement.setString(3, owner.getPhone());
            statement.setString(4, owner.getEmail());
            statement.setLong(5, owner.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void remove(Owner owner) {

    }

    @Override
    public Owner findOwnerById(Long id) {
        Owner owner = new Owner();
        String SQL = "select * from owner where id = ?";
        try {
            PreparedStatement statement = JdbcDaoInitializer.getConnection().prepareStatement(SQL);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            owner = fillOwnerFields(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return owner;
    }

    @Override
    public void delete(Long id) {
        String SQL = "delete from owner where id = ?";
        try {
            PreparedStatement statement = JdbcDaoInitializer.getConnection().prepareStatement(SQL);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private Owner fillOwnerFields(ResultSet resultSet) throws SQLException {
        Owner owner = new Owner();
        owner.setId(resultSet.getLong("id"));
        owner.setFirstname(resultSet.getString("firstname"));
        owner.setLastname(resultSet.getString("lastname"));
        owner.setPhone(resultSet.getString("phone"));
        owner.setEmail(resultSet.getString("email"));
        return owner;
    }
}
