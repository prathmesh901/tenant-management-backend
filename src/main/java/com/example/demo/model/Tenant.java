package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tenants")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String email;
    private String allocatedRoomNumber;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate joiningDate; 

    private Double registrationMeterReading; 
    
    private String idProofNumber = "TEMP123";
    private String permanentAddress = "India";
}