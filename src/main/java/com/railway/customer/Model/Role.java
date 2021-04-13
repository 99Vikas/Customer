package com.railway.customer.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("roles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role {
    private String email;
    private String role;
}