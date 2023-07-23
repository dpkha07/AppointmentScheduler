package com.example.AppointmentScheduler.repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.AppointmentScheduler.model.Appointment;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

    @Query(value = "SELECT * FROM appointment WHERE operator_id = ?1 AND service_status = 'active'", nativeQuery = true)
    List<Appointment> getAppointments(Long operatorId);


    // @Query(value = "SELECT * FROM appointment WHERE operator_id = ?1 AND service_status = 'active' AND service_date = CURDATE()", nativeQuery = true)
    // List<Appointment> getSlots(Long operatorId);

    @Query(value = "INSERT INTO appointment (operator_id, customer_id, service_date, service_start_time, service_end_time) VALUES (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    Appointment bookAppointment(@Param("operatorId") Long operatorId, @Param("customerId") Long customerId, @Param("serviceDate") String serviceDate, @Param("serviceStartTime") Long serviceStartTime, @Param("serviceEndTime") Long serviceEndTime);

    @Transactional
    @Modifying
    @Query(value = "UPDATE appointment SET service_status = 'cancelled' WHERE id = ?1", nativeQuery = true)
    int cancelAppointment(Long appointmentId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE appointment SET service_date = ?1, service_start_time = ?2, service_end_time = ?3 WHERE id = ?4 AND service_status != 'cancelled'", nativeQuery = true)
    int rescheduleAppointment(String serviceDate, Long serviceStartTime, Long serviceEndTime, Long id);

}
