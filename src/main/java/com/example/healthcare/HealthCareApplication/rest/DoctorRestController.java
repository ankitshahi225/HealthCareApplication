package com.example.healthcare.HealthCareApplication.rest;


import com.example.healthcare.HealthCareApplication.entity.Doctor;
import com.example.healthcare.HealthCareApplication.entity.Patient;
import com.example.healthcare.HealthCareApplication.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorRestController {


    // inject DoctorServiceInterface //
    private final DoctorService theDoctorService;

    @Autowired
    public DoctorRestController(DoctorService theDoctorService)
    {
        this.theDoctorService = theDoctorService;
    }

    //Create a doctor
    @PostMapping("/create")
    public Doctor createDoctor(@RequestBody Doctor theDoctor)
    {
        return theDoctorService.save(theDoctor);
    }

    //Get doctor by ID
    @GetMapping("/id/{id}")
    public Doctor getDoctor(@PathVariable int id)
    {
        return theDoctorService.findById(id);
    }


    //Get all the Doctor
    public List<Doctor> getAllDoctor()
    {
        return theDoctorService.findAll();
    }

    //Delete a doctor by ID
    @DeleteMapping("/id/{id}")
    public void deleteDoctor(@PathVariable int id)
    {
        theDoctorService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public void updatePatient(@PathVariable int id ,@RequestBody Doctor theDoctor)
    {
        Doctor updateDoctor = theDoctorService.findById(id);
        if (updateDoctor !=null)
        {
            updateDoctor.setFirstName(theDoctor.getFirstName());
            updateDoctor.setLastName(theDoctor.getLastName());
            updateDoctor.setSpecialization(theDoctor.getSpecialization());
            updateDoctor.setEmail(theDoctor.getEmail());
            updateDoctor.setPhone(theDoctor.getPhone());

            updateDoctor.setAppointments(theDoctor.getAppointments());

            theDoctorService.update(updateDoctor);
        }

    }
}
