package com.example.ktv.models.Position.Request;

import com.example.ktv.entities.PositionEntity;
import lombok.Data;

@Data
public class UpdatePositionM {
    private String name;
    private Long id;
    public void modelToEntity(PositionEntity position){

        position.setName(this.name);
        position.setId(this.id);

    }
}
