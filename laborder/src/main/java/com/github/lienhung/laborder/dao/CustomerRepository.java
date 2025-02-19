package com.github.lienhung.laborder.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.github.lienhung.laborder.models.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    @Query("{ isVip: '?0' }")
    public List<Customer> findByVipStatus(boolean isVip);
}
