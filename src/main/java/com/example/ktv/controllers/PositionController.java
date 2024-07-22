package com.example.ktv.controllers;

import com.example.ktv.exceptions.BaseException;
import com.example.ktv.models.Position.Request.CreatePositionM;
import com.example.ktv.models.Position.Request.UpdatePositionM;
import com.example.ktv.models.Position.Response.GetPositionByIdM;
import com.example.ktv.models.Position.Response.PositionResponseM;
import com.example.ktv.services.PositionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/position")
public class PositionController {
    private final PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @Operation(summary = "Insert New position.", description = "This endpoint use to create new position.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully insert.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request wrong input", content = @Content),
            @ApiResponse(responseCode = "417", description = "name incorrect or null", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    @PostMapping
    public ResponseEntity<PositionResponseM> createPosition(@RequestBody CreatePositionM positionM) throws BaseException {
       PositionResponseM position= positionService.createPosition(positionM);
        return  ResponseEntity.ok(position);
    }
    @Operation(summary = "Get all  position's information.", description = "This endpoint use to get all position's information.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully get.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request wrong input", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    @GetMapping
    public ResponseEntity<List<PositionResponseM>> getAllPosition(){
        return ResponseEntity.ok(positionService.getAllPositions());
    }

    @Operation(summary = "Get position's information by id.", description = "This endpoint use to get position information's by using id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully get.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request wrong input.", content = @Content),
            @ApiResponse(responseCode = "417", description = "position not found.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    @GetMapping("/{id}")
    public ResponseEntity<GetPositionByIdM> getPositionById(@PathVariable Long id) throws BaseException {
        GetPositionByIdM positionById = positionService.getPositionById(id);
        return  ResponseEntity.ok(positionById);
    }
    @Operation(summary = "Update position's information.", description = "This endpoint use to update or edit position's information.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully update.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request wrong input", content = @Content),
            @ApiResponse(responseCode = "417", description = "name incorrect or null", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    @PutMapping
    public ResponseEntity<GetPositionByIdM> updatePosition(@RequestBody UpdatePositionM positionM)throws  BaseException{
        GetPositionByIdM positionByIdM=new GetPositionByIdM();
        positionByIdM=positionService.updatePosition(positionM);
        return  ResponseEntity.ok(positionByIdM);
    }
    @Operation(summary = "Insert New position.", description = "This endpoint use to create new position.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully delete.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request wrong input", content = @Content),
            @ApiResponse(responseCode = "417", description = "position have staff you can not delete. please move or delete staff before.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePositionById(@PathVariable Long id) throws BaseException {
        String  message= positionService.deletePositionById(id);
        return ResponseEntity.ok(message);
    }


}
