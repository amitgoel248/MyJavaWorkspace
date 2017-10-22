package com.dodo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dodo.entity.ProductTransactionData;

@Repository 
public interface ProductDataRepository extends MongoRepository<ProductTransactionData, Long> {

}