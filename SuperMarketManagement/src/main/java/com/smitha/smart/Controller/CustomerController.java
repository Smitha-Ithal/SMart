package com.smitha.smart.Controller;

import com.smitha.smart.Model.customers;
import com.smitha.smart.Services.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class CustomerController {
    @Autowired
    private CustomerServiceImp customerService;

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public void insertCustomer(@RequestBody customers customer){
        customerService.insertCustomer(customer);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public List<customers> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public Optional<customers> getCustomerById(@PathVariable(value = "id") String id){
        return customerService.getCustomerById(id);
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.PUT)
    public void updateCustomer(@PathVariable(value = "id") String id, @RequestBody customers updateCustomer){
        customerService.updateCustomer(id, updateCustomer);
    }

    @RequestMapping(value = "/customer/delete/{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable(value = "id") String id){
        customerService.deleteCustomer(id);
    }

}
