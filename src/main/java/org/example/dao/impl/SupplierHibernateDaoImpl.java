package org.example.dao.impl;

import org.example.dao.SupplierDao;
import org.example.model.Supplier;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SupplierHibernateDaoImpl implements SupplierDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Supplier> findAll() {
        Session session = sessionFactory.openSession();
        List<Supplier> suppliers = session.createQuery("from Supplier").list();
        session.close();
        return suppliers;
    }

    @Override
    public void save(Supplier owner) {

    }

    @Override
    public void update(Supplier owner) {

    }

    @Override
    public void remove(Supplier owner) {

    }

    @Override
    public Supplier findSupplierById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
