package com.example.Bus.Reservation.repos;

import com.example.Bus.Reservation.entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface BusRepository extends JpaRepository<Bus,Long> {
}
