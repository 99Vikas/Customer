package com.railway.customer.Controller;

import com.railway.customer.ExceptionHandling.CustomerNotFoundException;
import com.railway.customer.Model.Customer;
import com.railway.customer.Service.CustomerService;
import com.railway.customer.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @Autowired
    RoleService roleService;

    @PostMapping("/signup")
    public Customer registerUser(@RequestBody Customer customer) {
        System.out.println(customer);
        customerService.createCustomer(customer);
//        roleService.createRole(user.getRole());
        return customer;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateUser(@PathVariable String id, @RequestBody Customer customer) {
        System.out.println(customer);
        Optional<Customer> customer1 = customerService.updateCustomer(id, customer);
        if (customer1.isPresent()) {
            return ResponseEntity.ok(customer1.get());
        } else throw new CustomerNotFoundException("Customer with id " + id + " is not available.");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Customer> deleteUser(@PathVariable String id) {
        Optional<Customer> customer = customerService.deleteCustomer(id);
        if (customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        } else throw new CustomerNotFoundException("Customer with id " + id + " is not available.");
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<Customer> getUserByEmail(@PathVariable String email) {
        Optional<Customer> customer = customerService.findCustomerByEmail(email);
        if (customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        }else throw new CustomerNotFoundException("Customer with email " + email + " is not available.");
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Customer> getUserById(@PathVariable String id) {
        Optional<Customer> customer = customerService.findCustomerById(id);
        if (customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        }else throw new CustomerNotFoundException("Customer with id " + id + " is not available.");
    }

}
