package com.railway.customer.Repository;

import com.railway.customer.Model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {
}
