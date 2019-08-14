package com.pawan.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pawan.springdemo.dao.CustomerDAO;
import com.pawan.springdemo.entity.Customer;

import javax.transaction.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        List<Customer> customers =customerDAO.getCustomerList();
        return customers;
    }

    @Override
    @Transactional
    public void addCustomer(Customer customer) {
        customerDAO.addCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int id) {

        return customerDAO.getCustomer(id);
    }

    @Override
    @Transactional
    public void deleteCustomer(int id) {
        customerDAO.deleteCustomer(id);
    }

}
