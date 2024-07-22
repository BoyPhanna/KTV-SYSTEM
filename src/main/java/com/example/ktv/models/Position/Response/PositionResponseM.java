package com.example.ktv.models.Position.Response;

import com.example.ktv.entities.PositionEntity;
import lombok.Data;

@Data
public class PositionResponseM {
    private Long id;
    private String name;
    public void EntityToModel(PositionEntity position){
        this.id=position.getId();
        this.name=position.getName();
    }

}
