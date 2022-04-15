package com.example.eclipse.mvcrestcustomer.api.services;


import org.springframework.stereotype.Service;

import com.example.eclipse.mvcrestcustomer.api.controllers.CustomerController;
import com.example.eclipse.mvcrestcustomer.api.model.Customer;
import com.example.eclipse.mvcrestcustomer.api.repositories.CustomerRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 */
@Service
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepository customerRepository;

    public CustomerServiceImpl( CustomerRepository customerRepository) {
     
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository
                .findAll()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public Customer getCustomerById(Long id) {

        return customerRepository.findById(id)
                
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public Customer createNewCustomer(Customer customer) {

        Customer savedCustomer = customerRepository.save(customer);
        savedCustomer.setCustomerUrl(getCustomerUrl(savedCustomer.getId()));
        savedCustomer = customerRepository.save(savedCustomer);
        return savedCustomer;
    }



    @Override
    public Customer saveCustomer(Long id, Customer customer) {
          customer.setId(id);
          customer.setCustomerUrl(getCustomerUrl(customer.getId()));
          
          Customer savedCustomer = customerRepository.save(customer);

          
          return savedCustomer;
    }

    @Override
    public Customer patchCustomer(Long id, Customer customer) {
        return customerRepository.findById(id)
        		.map(customersave -> {
        			
                    if(customer.getFirstname() != null){
                        customersave.setFirstname(customer.getFirstname());
                    }

                    if(customer.getLastname() != null){
                    	customersave.setLastname(customer.getLastname());
                    }

                   customersave.setCustomerUrl(getCustomerUrl(customersave.getId()));
        			
        			
                   customerRepository.save(customersave);
        			return customersave;
        			
        		
        		}

        ).orElseThrow(ResourceNotFoundException::new);
    }


    private String getCustomerUrl(Long id) {
        return CustomerController.BASE_URL + "/" + id;
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }
}
