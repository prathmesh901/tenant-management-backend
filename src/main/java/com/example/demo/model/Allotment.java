package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "allotments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Allotment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "allotment_id")
    private Long allotmentId;

    @ManyToOne
    @JoinColumn(name = "tenant_id", referencedColumnName = "id") // 👈 BILKUL SAHI! referencedColumnName ab "id" ho gaya hai
    private Tenant tenant;

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "room_id") // Yeh bilkul sahi hai, kyunki Room mein roomId hi hai
    private Room room;

    @Column(name = "joining_date", nullable = false)
    private LocalDate joiningDate;

    @Column(name = "security_deposit")
    private double securityDeposit;

    private String status = "ACTIVE";

    @Column(name = "allotment_date")
    private LocalDate allotmentDate;

    @Column(name = "is_active")
    private Boolean isActive;
}