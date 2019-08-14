package com.pawan.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pawan.springdemo.dao.CustomerDAO;
import com.pawan.springdemo.entity.Customer;
import com.pawan.springdemo.service.CustomerService;



@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/list")
    public String showList(Model theModel) {

        List<Customer> customers = customerService.getCustomers();
        theModel.addAttribute("customers",customers);
        return "customer-list";
    }

    @GetMapping("/showFormForAdd")
    public String showForm(Model theModel) {
        theModel.addAttribute("customer",new Customer());
        return "customer-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showUpdateForm(@RequestParam("customerId") int id,Model theModel) {
        Customer customer = customerService.getCustomer(id);
        theModel.addAttribute("customer",customer);
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int id) {
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }

    @PostMapping("/processForm")
    public String processForm(@ModelAttribute("customer") Customer theCustomer) {
        customerService.addCustomer(theCustomer);
        return "redirect:/customer/list";
    }
}
