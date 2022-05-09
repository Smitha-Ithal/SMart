package com.smitha.smart.Services;

import com.smitha.smart.Model.customers;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    public int insertCustomer(customers customer);
    public List<customers> getAllCustomers();
    public Optional<customers> getCustomerById(String id);
    public int updateCustomer(String id, customers customer);
    public int deleteCustomer(String id);
}
