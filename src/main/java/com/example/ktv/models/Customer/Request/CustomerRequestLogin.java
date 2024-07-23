package com.example.ktv.models.Customer.Request;

import lombok.Data;

@Data
public class CustomerRequestLogin {
    private String email;
    private String password;
}
