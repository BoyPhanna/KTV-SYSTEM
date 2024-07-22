package com.example.ktv.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity(name = "tbCheckIn")
public class CheckInEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private LocalDateTime deleteAt;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomEntity room;
    private  LocalDateTime dateCheckIn;

    @OneToOne(mappedBy = "checkIn",cascade = CascadeType.ALL)
    private CheckOutEntity checkOut;

    @OneToOne(mappedBy = "checkIn")
    private InvoiceEntity invoice;

}
