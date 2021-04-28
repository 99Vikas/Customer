package com.railway.customer.Controller;

import com.railway.customer.ExceptionHandling.CustomerNotFoundException;
import com.railway.customer.Model.Customer;
import com.railway.customer.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @Bean
    private BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @PostMapping("/signup")
    public Customer registerCustomer(@RequestBody Customer customer) {
        System.out.println(customer);
        customer.setPassword(bCryptPasswordEncoder().encode(customer.getPassword()));
        customerService.createCustomer(customer);
        return customer;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable String id, @RequestBody Customer customer) {
        System.out.println(customer);
        Optional<Customer> customer1 = customerService.updateCustomer(id, customer);
        if (customer1.isPresent()) {
            return ResponseEntity.ok(customer1.get());
        } else throw new CustomerNotFoundException("Customer with id " + id + " is not available.");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable String id) {
        Optional<Customer> customer = customerService.deleteCustomer(id);
        if (customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        } else throw new CustomerNotFoundException("Customer with id " + id + " is not available.");
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<Customer> getCustomerByEmail(@PathVariable String email) {
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
    @GetMapping("/getAll")
    public ResponseEntity<List<Customer>> getAllUsers() {
        Optional<List<Customer>> customers = Optional.ofNullable(customerService.getAll());
        if (customers.isPresent()) {
            return ResponseEntity.ok(customers.get());
        }else throw new CustomerNotFoundException("Customers are not available.");
    }

}
