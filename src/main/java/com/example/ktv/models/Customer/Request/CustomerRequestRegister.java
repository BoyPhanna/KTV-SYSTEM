package com.example.ktv.models.Customer.Request;

import com.example.ktv.entities.CustomerEntity;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerRequestRegister {
    private  String name;
    private Character gender;
    private LocalDate dob;
    private String address;
    private String phone;
    private String email;
    private  String password;
    private String confirmPassword;
    public void modelToEntity(CustomerEntity customer){
        customer.setName(this.name);
        customer.setGender(this.gender);
        customer.setDob(this.dob);
        customer.setAddress(this.address);
        customer.setPhone(this.phone);
        customer.setEmail(this.email);
        customer.setPassword(this.password);
    }

}
