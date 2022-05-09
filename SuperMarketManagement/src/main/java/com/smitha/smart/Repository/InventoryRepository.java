package com.smitha.smart.Repository;

import com.smitha.smart.Model.productInventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends MongoRepository<productInventory, String> {

}
