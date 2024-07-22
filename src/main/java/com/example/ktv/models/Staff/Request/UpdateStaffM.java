package com.example.ktv.models.Staff.Request;

import com.example.ktv.entities.StaffEntity;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateStaffM {
    private  Long id;
    private  String name;
    private Character gender;
    private LocalDate dob;
    private String address;
    private String phone;
    private Double salary=100.0;
    private Long positionID;
    public void modelToEntity(StaffEntity staff){
        staff.setId(this.id);
        staff.setName(this.name);
        staff.setGender(Character.toUpperCase(this.gender));
        staff.setDob(this.dob);
        staff.setAddress(this.address);
        staff.setPhone(this.phone);
        staff.setSalary(this.salary);

    }
}
