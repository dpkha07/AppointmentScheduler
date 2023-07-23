package com.example.AppointmentScheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.example.AppointmentScheduler.service", "com.example.AppointmentScheduler.controller", "com.example.AppointmentScheduler.model", "com.example.AppointmentScheduler.repository", "com.example.AppointmentScheduler.service.impl"})
@SpringBootApplication
public class AppointmentSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppointmentSchedulerApplication.class, args);
	}

}
