package com.example.Bus.Reservation.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bus {
    private Long busId;
    private String busName;
    private String busNumber;
    private String busType;
    private Integer totalSeat;


}

