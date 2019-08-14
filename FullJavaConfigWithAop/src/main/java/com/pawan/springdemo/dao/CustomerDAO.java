package com.pawan.springdemo.dao;
import java.util.List;

import com.pawan.springdemo.entity.*;

public interface CustomerDAO {

    public List<Customer> getCustomerList();
    public void addCustomer(Customer customer);
    public Customer getCustomer(int id);
    public void deleteCustomer(int id);
}
