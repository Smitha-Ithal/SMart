package com.smitha.smart.Repository;

import com.smitha.smart.Model.productPurchase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPurchaseRepository extends MongoRepository<productPurchase, String> {

}
