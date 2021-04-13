package com.railway.customer.Service;

import com.railway.customer.Model.Role;
import com.railway.customer.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role createRole(Role role){
        return roleRepository.save(role);
    }

    public Role updateRole(Role role){
        return roleRepository.save(role);
    }

}