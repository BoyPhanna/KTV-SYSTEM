package com.example.ktv.models.Customer.Response;

import com.example.ktv.entities.CustomerEntity;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerResponseRegisterSuccess {
    private Long id;
    private  String name;
    private String phone;
    private String email;

    public void entityToModel(CustomerEntity customer){
        this.id=customer.getId();
        this.name=customer.getName();
        this.phone=customer.getPhone();
        this.email=customer.getEmail();
    }

}
