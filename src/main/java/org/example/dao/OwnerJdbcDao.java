package org.example.dao;

import org.example.model.Owner;

import java.util.List;

public interface OwnerJdbcDao {
    List<Owner> findAll();
    void save(Owner owner);
    void update(Owner owner);
    void remove(Owner owner);
    Owner findOwnerById(Long id);

    void delete(Long id);
}
