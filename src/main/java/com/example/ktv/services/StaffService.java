package com.example.ktv.services;

import com.example.ktv.entities.PositionEntity;
import com.example.ktv.entities.StaffEntity;
import com.example.ktv.exceptions.BaseException;
import com.example.ktv.exceptions.ImageExecption;
import com.example.ktv.exceptions.PositionException;
import com.example.ktv.exceptions.StaffException;
import com.example.ktv.models.Staff.Request.CreateStaffM;
import com.example.ktv.models.Staff.Request.UpdateStaffM;
import com.example.ktv.models.Staff.Response.StaffResponseCreateM;
import com.example.ktv.models.Staff.Response.StaffResponsePositionM;
import com.example.ktv.repositories.PositionRepository;
import com.example.ktv.repositories.StaffRepository;
import com.example.ktv.utils.Validators;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service

public class StaffService {
//    @Value("${upload.directory}")
//    private String uploadDirectory;
    private  final StaffRepository staffRepository;
    private final PositionRepository positionRepository;

    public StaffService(StaffRepository staffRepository, PositionRepository positionRepository) {
        this.staffRepository = staffRepository;
        this.positionRepository = positionRepository;
    }

    public StaffResponseCreateM createStaff(CreateStaffM staffM) throws BaseException {
       //Check null
        if(Objects.isNull(staffM.getName())){
            System.out.println("Name : ");
            System.out.println(staffM.getName());
            throw StaffException.nameIsNull();
        }
        if (Objects.isNull(staffM.getGender())){
            throw StaffException.genderIsNull();
        }
        if (Objects.isNull(staffM.getDob())){
            throw StaffException.dobIsNull();
        }
        if (Objects.isNull(staffM.getAddress())){
            throw StaffException.addressIsNull();
        } if (Objects.isNull(staffM.getPhone())){
            throw StaffException.phoneIsNull();
        } if (Objects.isNull(staffM.getSalary())){
            throw StaffException.salaryIsNull();
        } if (Objects.isNull(staffM.getPassword())){
            throw StaffException.passwordIsNull();
        } if (Objects.isNull(staffM.getEmail())){
            throw StaffException.emailIsNull();
        }
        if(Objects.isNull(staffM.getPositionID())){
            throw PositionException.positionNotFound();
        }
        if(!Validators.isValidEmail(staffM.getEmail())){
           throw  StaffException.emailIncorrect();
        }
        if(!Validators.isValidPhoneNumber(staffM.getPhone())){
            throw StaffException.phoneIncorrect();
        }
        if(staffM.getSalary()<10){
            throw  StaffException.salaryIncorrect();
        }
        if(!Validators.isValidName(staffM.getName())){
            throw StaffException.nameIncorrect();
        }
        if(!Validators.isValidGender(staffM.getGender())){
            throw  StaffException.genderIncorrect();
        }
        //Check empty
        PositionEntity position=new PositionEntity();
        try {
            position=positionRepository.findById(staffM.getPositionID()).orElseThrow();

        }catch (Exception e){
          throw   PositionException.positionNotFound();
        }



        //TODO create staff
        StaffEntity staff=new StaffEntity();
        staff.setCreateAt(LocalDateTime.now());
        staffM.modelToEntity(staff);
        staff.setPosition(position);
//try {
//    staff.setImage(file.getBytes());
//}catch (IOException e){
//    throw StaffException.nameIncorrect();
//}
        staff= staffRepository.save(staff);
        StaffResponseCreateM staffResponseCreateM=new StaffResponseCreateM();
        staffResponseCreateM.entityToModel(staff);

        return  staffResponseCreateM;
    }


    public List<StaffResponsePositionM> getAllStaffs(){
        List<StaffResponsePositionM> staffResponsePositionMS=new ArrayList<>();
        List<StaffEntity> staffEntities=staffRepository.findAll();
        for(StaffEntity staff:staffEntities){
            if(staff.getDeleteAt()==null){
                StaffResponsePositionM staffResponsePositionM=new StaffResponsePositionM();
                staffResponsePositionM.entityToModel(staff);
                staffResponsePositionMS.add(staffResponsePositionM);
            }
        }
        return staffResponsePositionMS;
    }
    public StaffResponsePositionM updateStaff(UpdateStaffM staffM) throws BaseException{
        if(Objects.isNull(staffM.getId())){
            throw StaffException.staffNotFound();
        }
        if(staffM.getId()<1){
            throw StaffException.staffNotFound();
        }
        if(Objects.isNull(staffM.getName())){
            System.out.println("Name : ");
            System.out.println(staffM.getName());
            throw StaffException.nameIsNull();
        }
        if (Objects.isNull(staffM.getGender())){
            throw StaffException.genderIsNull();
        }
        if (Objects.isNull(staffM.getDob())){
            throw StaffException.dobIsNull();
        }
        if (Objects.isNull(staffM.getAddress())){
            throw StaffException.addressIsNull();
        } if (Objects.isNull(staffM.getPhone())){
            throw StaffException.phoneIsNull();
        } if (Objects.isNull(staffM.getSalary())){
            throw StaffException.salaryIsNull();
        }
        if(Objects.isNull(staffM.getPositionID())){
            throw PositionException.positionNotFound();
        }

        if(!Validators.isValidPhoneNumber(staffM.getPhone())){
            throw StaffException.phoneIncorrect();
        }
        if(staffM.getSalary()<10){
            throw  StaffException.salaryIncorrect();
        }
        if(!Validators.isValidName(staffM.getName())){
            throw StaffException.nameIncorrect();
        }
        if(!Validators.isValidGender(staffM.getGender())){
            throw  StaffException.genderIncorrect();
        }

        StaffEntity staff=new StaffEntity();
        try {
            staff=staffRepository.findById(staffM.getId()).orElseThrow();
            if (!Objects.isNull(staff.getDeleteAt())){
                throw StaffException.staffNotFound();
            }
        }catch (Exception e){
            throw StaffException.staffNotFound();
        }

        staffM.modelToEntity(staff);
        staff.setUpdateAt(LocalDateTime.now());
        staff= staffRepository.save(staff);
        StaffResponsePositionM staffResponsePositionM=new StaffResponsePositionM();
        staffResponsePositionM.entityToModel(staff);
        return staffResponsePositionM;
    }
    public StaffResponsePositionM uploadImage(Long id,MultipartFile file)throws  BaseException{
        if(!(Objects.equals(file.getContentType(), "image/jpeg")||Objects.equals(file.getContentType(), "image/png"))){
            throw ImageExecption.fileNotSupport();
        }
        if(Objects.isNull(file)){
            throw ImageExecption.fileNotSupport();
        }
        StaffEntity staff=new StaffEntity();
        try {
            String uploadDirectory="uploads";
            staff= staffRepository.findById(id).orElseThrow();

            if(!Objects.isNull(staff.getDeleteAt())){
                throw StaffException.staffNotFound();
            }
            String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
            Path path = Paths.get(uploadDirectory + File.separator + fileName);

            // Save the file locally
            Files.createDirectories(path.getParent());
            Files.write(path, file.getBytes());

            // Construct the file URL (adjust as necessary for your environment)
            String fileUrl = "http://localhost:8000/uploads/" + fileName;
            staff.setImageURL(fileUrl);
            staff.setUpdateAt(LocalDateTime.now());
           staff= staffRepository.save(staff);

        }catch (Exception e){
            throw StaffException.staffNotFound();
        }

        StaffResponsePositionM staffResponseCreateM=new StaffResponsePositionM();
        staffResponseCreateM.entityToModel(staff);

        return staffResponseCreateM;
    }

    public StaffResponsePositionM getStaffById(Long id) throws BaseException{
        StaffEntity staff=new StaffEntity();
        try {
            staff=staffRepository.findById(id).orElseThrow();

        }catch (Exception e){
            throw  StaffException.staffNotFound();
        }
        if(!Objects.isNull(staff.getDeleteAt())){
            throw StaffException.staffNotFound();
        }
        StaffResponsePositionM staffResponsePositionM=new StaffResponsePositionM();
        staffResponsePositionM.entityToModel(staff);
        return  staffResponsePositionM;
    }
    public String deleteStaffById(Long id)throws BaseException{
        StaffEntity staff=new StaffEntity();
        try {
            staff=staffRepository.findById(id).orElseThrow();

        }catch (Exception e){
            StaffException.staffNotFound();
        }
        if(!Objects.isNull(staff.getDeleteAt())){
            throw StaffException.staffNotFound();
        }
        staff.setDeleteAt(LocalDateTime.now());
        staffRepository.save(staff);
        return "Delete success!";
    }


}
