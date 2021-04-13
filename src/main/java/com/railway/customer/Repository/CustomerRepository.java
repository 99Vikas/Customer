package com.railway.customer.Repository;

import com.railway.customer.Model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    public void deleteByEmail(String email);

    public Optional<Customer> findByEmail(String email);

}