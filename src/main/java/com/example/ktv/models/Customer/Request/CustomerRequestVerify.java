package com.example.ktv.models.Customer.Request;

import lombok.Data;

@Data
public class CustomerRequestVerify {
    private String email;
    private String verifyCode;
}
