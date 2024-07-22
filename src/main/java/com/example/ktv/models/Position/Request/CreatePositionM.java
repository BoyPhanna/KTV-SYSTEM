package com.example.ktv.models.Position.Request;

import com.example.ktv.entities.PositionEntity;
import lombok.Data;

@Data
public class CreatePositionM {
    private String name;
    public  PositionEntity modelToEntity(){
        PositionEntity position=new PositionEntity();
        position.setName(this.name);
        return  position;
    }

}
