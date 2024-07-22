package com.example.ktv.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "tbStaff")
public class StaffEntity {
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
    private Double salary=100.0;
    private String role="USER";
    private  String password;
    private String email;
    private String imageURL;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private PositionEntity position;

    @OneToMany(mappedBy = "staff",cascade = CascadeType.ALL)
    List<ImportEntity> importProducts=new ArrayList<>();

    @OneToMany(mappedBy = "staff")
    List<InvoiceEntity> invoices=new ArrayList<>();

}
