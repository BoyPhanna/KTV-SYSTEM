package com.example.ktv.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "tbCustomer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private LocalDateTime deleteAt;
    private  String name;
    private Character gender;
    private LocalDate dob;
    private String address;
    private String phone;
    private String role="CUSTOMER";
    private  String password;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<BookingEntity> bookings=new ArrayList<>();
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<CheckInEntity> checkIns=new ArrayList<>();
}
