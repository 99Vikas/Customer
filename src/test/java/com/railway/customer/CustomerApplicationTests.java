package com.railway.customer;

import com.railway.customer.Model.Customer;
import com.railway.customer.Service.CustomerService;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ExtendWith(SpringExtension.class)
@WebMvcTest
public class CustomerApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CustomerService customerService;

    @Test
    public void testGetAllCustomer() throws Exception {

        Customer customer1=new Customer();
        customer1.setId("1");
        customer1.setFirstName("Vikas");
        customer1.setLastName("Chauhan");
        customer1.setEmail("vikas@gmail.com");
        customer1.setMobileNumber("9598475666");
        customer1.setPassword("12345");
        customer1.setRole("admin");

        Customer customer2=new Customer();
        customer2.setId("2");
        customer2.setFirstName("Amman");
        customer2.setLastName("Chauhan");
        customer2.setEmail("vikas1@gmail.com");
        customer2.setMobileNumber("9598475666");
        customer2.setPassword("12345");
        customer2.setRole("user");

        Mockito.when(customerService.getAll()).thenReturn(Arrays.asList(customer1,customer2));


        mockMvc.perform(MockMvcRequestBuilders.get("/customer/getAll")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testFindCustomerByEmail() throws Exception{

        Customer customer=new Customer();
        customer.setId("2");
        customer.setFirstName("Amman");
        customer.setLastName("Chauhan");
        customer.setEmail("vikas1@gmail.com");
        customer.setMobileNumber("9598475666");
        customer.setPassword("12345");
        customer.setRole("user");

        Mockito.when(customerService.findCustomerByEmail("vikas1@gmail.com")).thenReturn(java.util.Optional.of(customer));

        mockMvc.perform(MockMvcRequestBuilders.get("/customer/getByEmail/{email}","vikas1@gmail.com")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testFindCustomerById() throws Exception{

        Customer customer=new Customer();
        customer.setId("2");
        customer.setFirstName("Amman");
        customer.setLastName("Chauhan");
        customer.setEmail("vikas1@gmail.com");
        customer.setMobileNumber("9598475666");
        customer.setPassword("12345");
        customer.setRole("user");

        Mockito.when(customerService.findCustomerById("2")).thenReturn(java.util.Optional.of(customer));

        mockMvc.perform(MockMvcRequestBuilders.get("/customer/getById/{id}","2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void testDeleteCustomer() throws Exception{

        Customer customer=new Customer();
        customer.setId("2");
        customer.setFirstName("Amman");
        customer.setLastName("Chauhan");
        customer.setEmail("vikas1@gmail.com");
        customer.setMobileNumber("9598475666");
        customer.setPassword("12345");
        customer.setRole("user");

        Mockito.when(customerService.deleteCustomer("2")).thenReturn(java.util.Optional.of(customer));

        mockMvc.perform(MockMvcRequestBuilders.get("/customer/delete/{id}","2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
