package com.example.AppointmentScheduler.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AppointmentScheduler.model.Appointment;
import com.example.AppointmentScheduler.repository.AppointmentRepository;
import com.example.AppointmentScheduler.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> getAppointments(Long serviceOperatorId) {
        try {
            if (serviceOperatorId == null) {
                throw new IllegalArgumentException("Service Operator ID cannot be null");
            }
            List<Appointment> result = appointmentRepository.getAppointments(serviceOperatorId);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // @Override
    // public List<Appointment> getSlots(Long serviceOperatorId) {
    //     try {
    //         if (serviceOperatorId == null) {
    //             throw new IllegalArgumentException("Service Operator ID cannot be null");
    //         }
    //         List<Appointment> result = appointmentRepository.getSlots(serviceOperatorId);
    //         System.out.println("result: " + result);
    //         return result;
    //     } catch (Exception e) {
    //         throw new RuntimeException(e);
    //     }
    // }

    @Override
    public Appointment bookAppointment(Appointment appointment) {
        try {
            if(appointment == null) {
                throw new IllegalArgumentException("Appointment data cannot be null");
            }
            
            return appointmentRepository.save(appointment);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int cancelAppointment(Long appointmentId) {
        try {
            if(appointmentId == null) {
                throw new IllegalArgumentException("Appointment ID cannot be null");
            }
            return appointmentRepository.cancelAppointment(appointmentId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int rescheduleAppointment(String serviceDate, Long serviceStartTime, Long serviceEndTime, Long id) {
        try {
            return appointmentRepository.rescheduleAppointment(serviceDate, serviceStartTime, serviceEndTime, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public AppointmentRepository getAppointmentRepository() {
        return appointmentRepository;
    }

    public void setAppointmentRepository(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }
}
