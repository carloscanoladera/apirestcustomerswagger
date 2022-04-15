package com.example.eclipse.mvcrestcustomer.api.services;





import java.util.List;

import com.example.eclipse.mvcrestcustomer.api.model.Customer;


/**
 * 
 */
public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer getCustomerById(Long id);

    Customer createNewCustomer(Customer customer);

    Customer saveCustomer(Long id, Customer customer);

    Customer patchCustomer(Long id, Customer customer);

    void deleteCustomerById(Long id);
}
