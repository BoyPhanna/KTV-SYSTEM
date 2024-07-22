package com.example.ktv.models.Position.Response;

import com.example.ktv.entities.PositionEntity;
import com.example.ktv.entities.StaffEntity;
import com.example.ktv.models.Staff.Response.StaffResponsePositionM;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GetPositionByIdM {
    private Long id;
    private String name;
    private List<StaffResponsePositionM> staffs=new ArrayList<>();
    public void EntityToModel(PositionEntity position){
        this.id=position.getId();
        this.name=position.getName();
        for(StaffEntity staff:position.getStaffs()){
            StaffResponsePositionM staffResponsePositionM=new StaffResponsePositionM();
            staffResponsePositionM.entityToModel(staff);
            this.staffs.add(staffResponsePositionM);
        }
    }
}
