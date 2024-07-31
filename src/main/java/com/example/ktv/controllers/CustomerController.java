package com.example.ktv.controllers;

import com.example.ktv.exceptions.BaseException;
import com.example.ktv.models.Customer.Request.CustomerRequestLogin;
import com.example.ktv.models.Customer.Request.CustomerRequestRegister;
import com.example.ktv.models.Customer.Request.CustomerRequestVerify;
import com.example.ktv.models.Customer.Response.CustomerResponseRegisterSuccess;
import com.example.ktv.services.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Customer register.", description = "This endpoint use to insert new customer by register.after register if you input real email backend will send verify code to your email to verify your account.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully register.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request wrong input", content = @Content),
            @ApiResponse(responseCode = "417", description = "Email exists or your information incorrect.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    @PostMapping("/register")
    public ResponseEntity<CustomerResponseRegisterSuccess> register(@RequestBody CustomerRequestRegister customerRequestRegister) throws BaseException {
        CustomerResponseRegisterSuccess customerResponseRegisterSuccess=customerService.register(customerRequestRegister);
        return ResponseEntity.ok(customerResponseRegisterSuccess);
    }

    @Operation(summary = "Customer login.", description = "This endpoint use to login to web app by using email and password.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully login.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request wrong input", content = @Content),
            @ApiResponse(responseCode = "417", description = "Email or password incorrect.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    @PostMapping("/login")
    private ResponseEntity<String> login(@RequestBody CustomerRequestLogin customerRequestLogin)throws  BaseException{
        String message=customerService.login(customerRequestLogin);
        return ResponseEntity.ok(message);
    }
    @Operation(summary = "Customer verify account.", description = "This endpoint use to verify your account after you register. You have to input your email that you register and verify code that backend sended to your email.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully verify.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request wrong input", content = @Content),
            @ApiResponse(responseCode = "417", description = "Email or verify code incorrect.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    @PostMapping("/verify")
    private ResponseEntity<String> verifyAccount(@RequestBody CustomerRequestVerify customerRequestVerify)throws BaseException{
        String message=customerService.verifyAccount(customerRequestVerify);
        return ResponseEntity.ok(message);
    }

}
