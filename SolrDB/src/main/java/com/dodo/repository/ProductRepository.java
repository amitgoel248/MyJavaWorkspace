package com.dodo.repository;

import java.util.List;
import org.springframework.data.solr.repository.SolrCrudRepository;
import com.dodo.entity.Product;

public interface ProductRepository extends SolrCrudRepository<Product, String> {

	List<Product> findByProductNameStartingWith(String productName);

}