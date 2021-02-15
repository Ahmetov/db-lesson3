package org.example.dao;

import org.example.model.Owner;

import java.util.List;

public interface SupplierJdbcDao {
    List<Owner> findAll();
    void save(Owner owner);
    void update(Owner owner);
    void remove(Owner owner);
}
