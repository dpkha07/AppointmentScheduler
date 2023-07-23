package com.example.AppointmentScheduler.service;

import java.util.List;

import com.example.AppointmentScheduler.model.Appointment;

public interface AppointmentService {

    List<Appointment> getAppointments(Long serviceOperatorId);

    // List<Appointment> getSlots(Long serviceOperatorId);

    Appointment bookAppointment(Appointment appointment);

    int cancelAppointment(Long appointmentId);

    int rescheduleAppointment(String serviceDate, Long serviceStartTime, Long serviceEndTime, Long id);

}
