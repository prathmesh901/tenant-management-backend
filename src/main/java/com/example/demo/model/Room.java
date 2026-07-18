package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rooms")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long roomId;
    
    @Column(name = "room_number", nullable = false, unique = true)
    private String roomNumber;
    
    @Column(nullable = false)
    private int floor;
    
    @Column(name = "rent_amount")
    private double rentAmount;
    
    private String status = "AVAILABLE";
    
    @Column(name = "is_available")
    private Boolean isAvailable;
    
    @Column(name = "room_type")
    private String roomType;
}