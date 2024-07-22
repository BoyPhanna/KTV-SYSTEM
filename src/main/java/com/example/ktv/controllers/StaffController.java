package com.example.ktv.controllers;

import com.example.ktv.exceptions.BaseException;
import com.example.ktv.models.Staff.Request.CreateStaffM;
import com.example.ktv.models.Staff.Request.UpdateStaffM;
import com.example.ktv.models.Staff.Response.StaffResponseCreateM;
import com.example.ktv.models.Staff.Response.StaffResponsePositionM;
import com.example.ktv.services.StaffService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jdk.jfr.Name;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/staff")

public class StaffController {
    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @Operation(summary = "Insert new staff", description = "This endpoint use to insert new staff.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully insert.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request wrong input", content = @Content),
            @ApiResponse(responseCode = "417", description = "Staff not found or not some thing have incorrect.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    @PostMapping()
    public ResponseEntity<StaffResponseCreateM> createStaff( @RequestBody CreateStaffM staffM) throws BaseException{
        System.out.println("Name: ");
        System.out.println(staffM.getName());

        StaffResponseCreateM staffResponseCreateM=staffService.createStaff(staffM);
        return  ResponseEntity.ok(staffResponseCreateM);

    }

@Operation(summary = "Upload Image for staff", description = "This endpoint uploads an image file for staff information. Noted it support only content type .jpg and png ")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully uploaded", content = @Content),
        @ApiResponse(responseCode = "400", description = "Bad request wrong input", content = @Content),
        @ApiResponse(responseCode = "417", description = "Staff not found or not support image type.", content = @Content),
        @ApiResponse(responseCode = "500", description = "Internal server error"),
})
    @PostMapping(value = "/image",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StaffResponsePositionM> uploadImage(@RequestParam("staff_id") Long id,@RequestParam("file") MultipartFile file) throws BaseException {
            StaffResponsePositionM staffResponsePositionM=staffService.uploadImage(id,file);

        return ResponseEntity.ok(staffResponsePositionM);
    }


    @Operation(summary = "Get all of staff's information.", description = "This endpoint get all staff's information.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully get.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request wrong input", content = @Content),
            @ApiResponse(responseCode = "417", description = "Staff not found.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    @GetMapping
    public ResponseEntity<List<StaffResponsePositionM>> getAllStaffs(){
        return ResponseEntity.ok(staffService.getAllStaffs());
    }

    @Operation(summary = "Update Staff's information", description = "This endpoint use to update staff information.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully update", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request wrong input", content = @Content),
            @ApiResponse(responseCode = "417", description = "Staff not found or some information have wrong.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    @PutMapping
    public ResponseEntity<StaffResponsePositionM> updateStaff(@RequestBody UpdateStaffM staffM) throws BaseException {
        StaffResponsePositionM staffResponsePositionM=staffService.updateStaff(staffM);
        return ResponseEntity.ok(staffResponsePositionM);
    }


    @Operation(summary = "Get Staff's information by id.", description = "This endpoint use find staff by using id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully get.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request wrong input", content = @Content),
            @ApiResponse(responseCode = "417", description = "Staff not found.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    @GetMapping("/{id}")
    public  ResponseEntity<StaffResponsePositionM> getStaffById(@PathVariable Long id) throws BaseException{
        StaffResponsePositionM staffResponsePositionM=staffService.getStaffById(id);
        return ResponseEntity.ok(staffResponsePositionM);
    }

    @Operation(summary = "Delete Staff's information.", description = "This endpoint use to delete staff's information by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully delete.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request wrong input", content = @Content),
            @ApiResponse(responseCode = "417", description = "Staff not found.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStaffById(@PathVariable Long id) throws  BaseException{
        String messages=staffService.deleteStaffById(id);
        return ResponseEntity.ok(messages);
    }

}
