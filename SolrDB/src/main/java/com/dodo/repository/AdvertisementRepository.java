package com.dodo.repository;

import org.springframework.data.solr.repository.SolrCrudRepository;

import com.dodo.entity.Advertisement;

public interface AdvertisementRepository extends SolrCrudRepository<Advertisement, String> {
}