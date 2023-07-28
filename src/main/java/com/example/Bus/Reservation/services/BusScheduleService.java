package com.example.Bus.Reservation.services;

import com.example.Bus.Reservation.entities.BusSchedule;

import java.util.List;

public interface BusScheduleService {
    BusSchedule addSchedule(BusSchedule busSchedule);

    List<BusSchedule> getAllBusSchedules();

    List<BusSchedule> getScheduleByRoute(String routeName);
}
