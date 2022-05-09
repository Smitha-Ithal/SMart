package com.smitha.smart.Services;

import com.smitha.smart.Model.customers;
import com.smitha.smart.Repository.CustomerReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    CustomerReporsitory customerReporsitory;

    @Override
    public int insertCustomer(customers customer) {
        customerReporsitory.save(customer);
        return 1;
    }

    @Override
    public List<customers> getAllCustomers() {
        List<customers> cust = customerReporsitory.findAll();
        return cust;
    }

    @Override
    public Optional<customers> getCustomerById(String id) {
        Optional<customers> optionalCustomers = customerReporsitory.findById(id);
        if (optionalCustomers.isPresent()) {
            return optionalCustomers;
        } else {
            System.out.println("Not found!");
            return null;
        }
    }
    @Override
    public int updateCustomer(String id, customers customer) {
        Optional<customers> existingCustomer = customerReporsitory.findById(id.toString());
        if (existingCustomer.isPresent()) {
//            System.out.println("starting");
            customers updateCustomer = existingCustomer.get();
            if (customer.getName() != null) {
                updateCustomer.setName(customer.getName());
            }
            if (customer.getUsername() != null ) {
                updateCustomer.setUsername(customer.getUsername());
            }
            if(customer.getRole() != null){
                updateCustomer.setRole(customer.getRole());
            }
//            System.out.println("Complete!");
            customerReporsitory.save(updateCustomer);
            return 1;
        }
        return 0;
    }
    @Override
    public int deleteCustomer(String id) {
        customerReporsitory.deleteById(id.toString());
        return 1;
    }
}


