package com.example.ktv.models.Staff.Response;

import com.example.ktv.entities.StaffEntity;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StaffResponsePositionM {
    private Long id;
    private  String name;
    private Character gender;
    private LocalDate dob;
    private String address;
    private String phone;
    private Double salary=100.0;
    private String email;
    private String imageURL;
    public void entityToModel(StaffEntity staff){
        this.id=staff.getId();
        this.name=staff.getName();
        this.gender=staff.getGender();
        this.dob=staff.getDob();
        this.address=staff.getAddress();
        this.phone=staff.getPhone();
        this.salary=staff.getSalary();
        this.email=staff.getEmail();
        this.imageURL=staff.getImageURL();
    }

}
