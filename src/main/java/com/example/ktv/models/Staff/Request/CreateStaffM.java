package com.example.ktv.models.Staff.Request;

import com.example.ktv.entities.StaffEntity;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CreateStaffM {
    private  String name;
    private Character gender;
    private LocalDate dob;
    private String address;
    private String phone;
    private Double salary=100.0;
    private  String password;
    private String email;
    private Long positionID;
    public void modelToEntity(StaffEntity staff){

        staff.setName(this.name);
        staff.setGender(Character.toUpperCase(this.gender));
        staff.setDob(this.dob);
        staff.setAddress(this.address);
        staff.setPhone(this.phone);
        staff.setSalary(this.salary);
        staff.setEmail(this.email);
        staff.setPassword(this.password);
    }

}

