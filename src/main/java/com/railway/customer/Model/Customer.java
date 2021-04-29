package com.railway.customer.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("customers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String gender;
    @Indexed(unique = true)
    private String email;
    @Indexed(unique = true)
    private Date dob;
    private String mobileNumber;
    private String password;
    private String role;

    @Override
    public String toString() {
        return super.toString();
    }
}