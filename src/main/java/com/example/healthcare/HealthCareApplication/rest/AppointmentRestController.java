package com.example.healthcare.HealthCareApplication.rest;

import com.example.healthcare.HealthCareApplication.entity.Appointment;
import com.example.healthcare.HealthCareApplication.service.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentRestController {


    //Inject AppointmentService interface
    public AppointmentService appointmentService;

    public AppointmentRestController(AppointmentService appointmentService)
    {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/create")
    public Appointment createAppointment(@RequestBody Appointment theAppointment)
    {
        return appointmentService.save(theAppointment);
    }

    //Get Appointment by ID
    @GetMapping("/id/{id}")
    public Appointment getAppointment(@PathVariable int id)
    {
        return appointmentService.findById(id);
    }


    //Get all the Appointment
    public List<Appointment> getAllAppointment()
    {
        return appointmentService.findAll();
    }

    //Delete a Appointment by ID
    @DeleteMapping("/id/{id}")
    public void deleteAppointment(@PathVariable int id)
    {
        appointmentService.deleteById(id);
    }

    //Update the Appointment
    @PutMapping("/update/{id}")
    public void updateAppointment(@PathVariable int id,@RequestBody Appointment theAppointment)
    {
        Appointment updateAppointment = appointmentService.findById(id);
        if(updateAppointment != null)
        {
            updateAppointment.setAppointmentTime(theAppointment.getAppointmentTime());
            updateAppointment.setDoctor(theAppointment.getDoctor());
            updateAppointment.setPatient(theAppointment.getPatient());

            appointmentService.update(updateAppointment);
        }

    }
}
