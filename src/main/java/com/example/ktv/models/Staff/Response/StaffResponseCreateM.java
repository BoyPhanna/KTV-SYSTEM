package com.example.ktv.models.Staff.Response;

import com.example.ktv.entities.StaffEntity;
import lombok.Data;

@Data
public class StaffResponseCreateM {
    private Long id;
    private  String name;
    public void entityToModel(StaffEntity staff){
        this.id= staff.getId();
        this.name=staff.getName();
    }
}
