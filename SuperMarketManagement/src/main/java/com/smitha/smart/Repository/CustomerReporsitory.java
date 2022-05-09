package com.smitha.smart.Repository;

import com.smitha.smart.Model.customers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerReporsitory extends MongoRepository<customers, String> {



}
