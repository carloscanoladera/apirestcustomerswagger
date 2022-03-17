package com.example.eclipse.mvcrestcustomer.bootstrap;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.eclipse.mvcrestcustomer.api.model.Customer;
import com.example.eclipse.mvcrestcustomer.api.repositories.CustomerRepository;
import com.example.eclipse.mvcrestcustomer.api.services.CustomerService;



/**
 * Created by jt on 9/24/17.
 */
@Component
public class Bootstrap implements CommandLineRunner{


    private final CustomerService customerService;
    private final CustomerRepository customerRepository;


    public Bootstrap( CustomerService customerService, CustomerRepository customerRepository) {

        this.customerService = customerService;
        this.customerRepository=customerRepository;
   
    }

    @Override
    public void run(String... args) throws Exception {


        loadCustomers();

    }

 

    private void loadCustomers() {
        //given
        Customer customer1 = new Customer();
        customer1.setId(1l);
        customer1.setFirstname("Michale");
        customer1.setLastname("Weston");
        customerService.createNewCustomer(customer1);

        Customer customer2 = new Customer();
        customer2.setId(2l);
        customer2.setFirstname("Sam");
        customer2.setLastname("Axe");

        customerService.createNewCustomer(customer2);

        System.out.println("Customers Loaded: " + customerRepository.count());
    }
}
