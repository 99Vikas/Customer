package com.railway.customer;

import com.railway.customer.Model.Customer;
import com.railway.customer.Service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
                classes = CustomerApplication.class
)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class CustomerApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getCustomerTest() throws Exception{

        MvcResult mvcResult = mockMvc.perform
                (MockMvcRequestBuilders.get("/customer/getByEmail/")
                        .accept(MediaType.APPLICATION_JSON)
                ).andReturn();
    }

}
