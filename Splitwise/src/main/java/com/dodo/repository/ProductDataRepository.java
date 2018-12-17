package com.dodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dodo.entity.TransactionData;

@Repository 
public interface ProductDataRepository extends JpaRepository<TransactionData, String> {

}