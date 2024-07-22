package com.example.ktv.services;

import com.example.ktv.entities.PositionEntity;
import com.example.ktv.exceptions.BaseException;
import com.example.ktv.exceptions.PositionException;
import com.example.ktv.models.Position.Request.CreatePositionM;
import com.example.ktv.models.Position.Request.UpdatePositionM;
import com.example.ktv.models.Position.Response.GetPositionByIdM;
import com.example.ktv.models.Position.Response.PositionResponseM;
import com.example.ktv.repositories.PositionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PositionService {
    private final PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public PositionResponseM  createPosition(CreatePositionM positionM)throws BaseException {

        if(positionM.getName()==null){
            throw PositionException.nameIsNull();
        }
        if (positionM.getName().isEmpty()){
            throw PositionException.nameIsEmpty();
        }
        PositionEntity position=positionM.modelToEntity();
        position.setCreateAt(LocalDateTime.now());
        position = positionRepository.save(position);
        PositionResponseM positionResponseM=new PositionResponseM();
        positionResponseM.EntityToModel(position);
        return positionResponseM;
    }

    public List<PositionResponseM> getAllPositions(){
        List<PositionEntity> positionEntities=positionRepository.findAll();
        List<PositionResponseM> positionResponseMS=new ArrayList<>();
        for(PositionEntity position:positionEntities){
           if(position.getDeleteAt()==null){
               PositionResponseM positionResponseM=new PositionResponseM();
               positionResponseM.EntityToModel(position);
               positionResponseMS.add(positionResponseM);
           }
        }
        return positionResponseMS;
    }
    public GetPositionByIdM getPositionById(Long id)throws  BaseException{
        PositionEntity position=new PositionEntity();
        try {
            position = positionRepository.findById(id).orElseThrow();
        }catch (Exception e){
            throw  PositionException.positionNotFound();
        }
        if(position.getDeleteAt()!=null){
            throw PositionException.positionNotFound();
        }
//TODO Get By Id
       GetPositionByIdM positionByIdM=new GetPositionByIdM();

       positionByIdM.EntityToModel(position);
       return  positionByIdM;
    }
    public GetPositionByIdM updatePosition(UpdatePositionM positionM)throws BaseException{
        PositionEntity position=new PositionEntity();
        try {
            position = positionRepository.findById(positionM.getId()).orElseThrow();
        }catch (Exception e){
            throw  PositionException.positionNotFound();
        }
        if(position.getDeleteAt()!=null){
            throw PositionException.positionNotFound();
        }

        if(Objects.isNull(positionM.getName())){
            throw  PositionException.nameIsNull();
        }
        if(positionM.getName().isBlank() || positionM.getName().isEmpty()){
            throw  PositionException.nameIsEmpty();
        }
//TODO update
        positionM.modelToEntity(position);
        position.setUpdateAt(LocalDateTime.now());
        position =positionRepository.save(position);
        GetPositionByIdM positionResponseM=new GetPositionByIdM();
        positionResponseM.EntityToModel(position);
        return  positionResponseM;
    }

    public String deletePositionById(Long id)throws BaseException{
        PositionEntity position=new PositionEntity();
        try {
          position=  positionRepository.findById(id).orElseThrow();
        }
        catch (Exception e){
           throw  PositionException.positionNotFound();
        }

        if(!position.getStaffs().isEmpty()){
            throw  PositionException.haveStaffs();

        }
//TODO delete
        position.setDeleteAt(LocalDateTime.now());
        positionRepository.save(position);
        return  "delete.success";
    }


}
