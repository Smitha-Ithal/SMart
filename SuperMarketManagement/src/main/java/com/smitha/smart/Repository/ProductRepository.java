package com.smitha.smart.Repository;

import com.smitha.smart.Model.products;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<products, String> {

}
