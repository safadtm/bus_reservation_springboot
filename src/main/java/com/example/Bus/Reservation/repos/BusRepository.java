package com.example.Bus.Reservation.repos;

import com.example.Bus.Reservation.entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus,Long> {
}
