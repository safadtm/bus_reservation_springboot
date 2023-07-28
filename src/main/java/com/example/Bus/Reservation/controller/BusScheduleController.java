package com.example.Bus.Reservation.controller;

import com.example.Bus.Reservation.entities.BusSchedule;
import com.example.Bus.Reservation.models.ResponseModel;
import com.example.Bus.Reservation.services.BusScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/schedule")
public class BusScheduleController {
    @Autowired
    private BusScheduleService busScheduleService;

    @PostMapping("/add")
    public ResponseModel<BusSchedule> addSchedule(@RequestBody BusSchedule busSchedule){
        final BusSchedule schedule=busScheduleService.addSchedule(busSchedule);
        return  new ResponseModel<>(HttpStatus.OK.value(), "Schedule saved",schedule);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BusSchedule>> getAllSchedules(){
        return ResponseEntity.ok(busScheduleService.getAllBusSchedules());
    }

    @GetMapping("/{routeName}")
    public ResponseEntity<List<BusSchedule>> getBusScheduleByRouteName(@PathVariable(name = "routeName") String routeName){
       return ResponseEntity.ok(busScheduleService.getScheduleByRoute(routeName));
    }

}
