package com.pawan.springdemo.dao;
import com.pawan.springdemo.entity.*;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pawan.springdemo.dao.CustomerDAO;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomerList() {

        Session session = sessionFactory.getCurrentSession();

        //reading all data from customer and sorting it by first name of curstomer
        List<Customer> customers = session.createQuery("from Customer order by firstName").getResultList();
        return customers;
    }


    public void addCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.save(customer);
    }


    @Override
    public Customer getCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class,id);
    }


    @Override
    public void deleteCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, id);
        session.delete(customer);
    }
}
