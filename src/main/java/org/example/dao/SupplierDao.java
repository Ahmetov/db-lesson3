package org.example.dao;

import org.example.model.Supplier;
import java.util.List;

public interface SupplierDao {
    List<Supplier> findAll();
    void save(Supplier owner);
    void update(Supplier owner);
    void remove(Supplier owner);
    Supplier findSupplierById(Long id);
    void delete(Long id);
}
