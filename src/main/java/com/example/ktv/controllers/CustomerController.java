package com.example.ktv.controllers;

import com.example.ktv.exceptions.BaseException;
import com.example.ktv.models.Customer.Request.CustomerRequestLogin;
import com.example.ktv.models.Customer.Request.CustomerRequestRegister;
import com.example.ktv.models.Customer.Request.CustomerRequestVerify;
import com.example.ktv.models.Customer.Response.CustomerResponseRegisterSuccess;
import com.example.ktv.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public ResponseEntity<CustomerResponseRegisterSuccess> register(@RequestBody CustomerRequestRegister customerRequestRegister) throws BaseException {
        CustomerResponseRegisterSuccess customerResponseRegisterSuccess=customerService.register(customerRequestRegister);
        return ResponseEntity.ok(customerResponseRegisterSuccess);
    }
    @PostMapping("/login")
    private ResponseEntity<String> login(@RequestBody CustomerRequestLogin customerRequestLogin)throws  BaseException{
        String message=customerService.login(customerRequestLogin);
        return ResponseEntity.ok(message);
    }
    @PostMapping("/verify")
    private ResponseEntity<String> verifyAccount(@RequestBody CustomerRequestVerify customerRequestVerify)throws BaseException{
        String message=customerService.verifyAccount(customerRequestVerify);
        return ResponseEntity.ok(message);
    }

}
