package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNumber;
    private String tenantName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate billingStartDate; 

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate billingEndDate;   

    private Double previousReading;
    private Double currentReading;
    private Double totalUnits;
    private Double ratePerUnit = 10.0;
    private Double electricityAmount;

    private Double roomRent;
    private Double totalPayable;
    private Double amountPaid;
    private Double balanceDue;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastPaymentDate;
    
    private String status;
}