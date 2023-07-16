package com.example.Bus.Reservation.services.impl;

import com.example.Bus.Reservation.entities.Bus;
import com.example.Bus.Reservation.repos.BusRepository;
import com.example.Bus.Reservation.services.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceImpl implements BusService {
    @Autowired
    private BusRepository busRepository;
    @Override
    public Bus addBus(Bus bus) {
        return busRepository.save(bus);
    }

    @Override
    public List<Bus> getAllBus() {
        return busRepository.findAll();
    }
}
