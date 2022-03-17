package com.example.eclipse.mvcrestcustomer.api.services;





import java.util.List;

import com.example.eclipse.mvcrestcustomer.api.model.Customer;


/**
 * Created by jt on 9/27/17.
 */
public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer getCustomerById(Long id);

    Customer createNewCustomer(Customer customer);

    Customer saveCustomer(Long id, Customer customer);

    Customer patchCustomer(Long id, Customer customer);

    void deleteCustomerById(Long id);
}
