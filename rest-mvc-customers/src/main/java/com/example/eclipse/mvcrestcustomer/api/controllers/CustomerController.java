package com.example.eclipse.mvcrestcustomer.api.controllers;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.eclipse.mvcrestcustomer.api.model.Customer;
import com.example.eclipse.mvcrestcustomer.api.model.CustomerList;
import com.example.eclipse.mvcrestcustomer.api.services.CustomerService;

/**
 * 
 */
@RestController
@CrossOrigin({"http://127.0.0.1:5500/","localhost","localhost:8080","*"})
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

	public static final String BASE_URL = "/api/v1/customers";

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CustomerList getListOfCustomers(){
        return new CustomerList(customerService.getAllCustomers());
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createNewCustomer(@RequestBody Customer customer){
        return customerService.createNewCustomer(customer);
    }

    @PutMapping({"/{id}"})

    @ResponseStatus(HttpStatus.OK)
    public Customer updateCustomerUpdate(@PathVariable Long id, @RequestBody Customer customer){
        return customerService.saveCustomer(id, customer);
    }



    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Customer patchCustomer(@PathVariable Long id, @RequestBody Customer customer){
        return customerService.patchCustomer(id, customer);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomerById(id);
    }
}
