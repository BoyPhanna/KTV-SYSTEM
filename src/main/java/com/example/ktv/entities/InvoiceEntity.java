package com.example.ktv.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "tbInvoice")
public class InvoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private LocalDateTime deleteAt;

    @ManyToOne
    @JoinColumn(name = "checkIn_id")
    private CheckInEntity checkIn;
    @ManyToOne
    @JoinColumn(name = "checkout_id")
    private CheckOutEntity checkOut;
    @ManyToOne
    @JoinColumn(name = "staff_id")
    private StaffEntity staff;

    private Double productAmount;
    private Integer time;
    private Double roomAmount;

    @OneToMany(mappedBy = "invoice",cascade = CascadeType.ALL)
    List<InvoiceDetailEntity> invoiceDetails=new ArrayList<>();
}
