package com.example.ktv.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "tbRoom")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private LocalDateTime deleteAt;
    private String type="Normal";
    private Double pricePH=0.0;
    private Boolean status=false;

    @OneToMany(mappedBy = "room",cascade = CascadeType.ALL)
    List<BookingEntity> bookings=new ArrayList<>();

    @OneToMany(mappedBy = "room",cascade = CascadeType.ALL)
    List<CheckInEntity> checkIns=new ArrayList<>();
}
