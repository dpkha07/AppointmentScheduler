package com.example.AppointmentScheduler.controller;

import com.example.AppointmentScheduler.model.Appointment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AppointmentScheduler.service.AppointmentService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

@RestController
@Validated
@RequestMapping("/api/v1/")
public class AppointmentController {
    
    @Autowired
    private AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/appointments/{serviceOperatorId}")
    public ResponseEntity<List<Appointment>> getAppointments(@PathVariable("serviceOperatorId") Long serviceOperatorId) {
        return new ResponseEntity<List<Appointment>>(appointmentService.getAppointments(serviceOperatorId), HttpStatus.OK);
    }

    // @GetMapping("/appointments/slots/{serviceOperatorId}")
    // public ResponseEntity<List<Appointment>> getSlots(@PathVariable("serviceOperatorId") Long serviceOperatorId) {
    //     return new ResponseEntity<List<Appointment>>(appointmentService.getSlots(serviceOperatorId), HttpStatus.OK);
    // }

    @PostMapping("/appointments/book")
    public ResponseEntity<Appointment> bookAppointment(@RequestBody Appointment appointment) {
        return new ResponseEntity<Appointment>(appointmentService.bookAppointment(appointment), HttpStatus.OK);
    }

    @GetMapping("/appointments/cancel/{appointmentId}")
    public ResponseEntity<?> cancelAppointment(@PathVariable("appointmentId") Long appointmentId) {
        return new ResponseEntity<>(appointmentService.cancelAppointment(appointmentId), HttpStatus.OK);
    }

    @PostMapping("/appointments/reschedule")
    public ResponseEntity<?> rescheduleAppointment(@RequestBody Map<String, Object> payload) {
        if(payload == null) {
            throw new IllegalArgumentException("Appointment data cannot be null");
        }
        System.out.println(payload.get("operatorId"));
        String serviceDate = (String)payload.get("serviceDate");
        Long serviceStartTime = Long.valueOf(payload.get("serviceStartTime").toString());
        Long serviceEndTime = Long.valueOf(payload.get("serviceEndTime").toString());
        Long id = Long.valueOf(payload.get("id").toString());
        return new ResponseEntity<>(appointmentService.rescheduleAppointment(serviceDate, serviceStartTime, serviceEndTime, id), HttpStatus.OK);
    }

    public AppointmentService getAppointmentService() {
        return appointmentService;
    }


    public void setAppointmentService(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }


}
