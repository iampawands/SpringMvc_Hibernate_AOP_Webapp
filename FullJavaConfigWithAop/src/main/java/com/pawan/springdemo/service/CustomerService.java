package com.pawan.springdemo.service;
import java.util.*;
import com.pawan.springdemo.entity.*;

public interface CustomerService {

    public List<Customer> getCustomers();

    public void addCustomer(Customer customer);

    public Customer getCustomer(int id);

    public void deleteCustomer(int id);
}
