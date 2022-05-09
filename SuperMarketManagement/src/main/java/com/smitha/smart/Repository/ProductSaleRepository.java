package com.smitha.smart.Repository;

import com.smitha.smart.Model.productSale;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductSaleRepository extends MongoRepository<productSale, String> {

    @Query("{_id :?0}")
    Optional<productSale> findById(String id);
}
