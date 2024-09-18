package com.example.healthcare.HealthCareApplication.rest;


import com.example.healthcare.HealthCareApplication.entity.Patient;
import com.example.healthcare.HealthCareApplication.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientRestController {


    //Inject Patient Service Interface

    private final PatientService patientService;

    @Autowired
    public PatientRestController(PatientService patientService)
    {
        this.patientService=patientService;
    }


    @PostMapping("/create")
    public Patient createPatient(@RequestBody Patient thePatient)
    {
        return patientService.save(thePatient);
    }

    //Get Patient by ID
    @GetMapping("/id/{id}")
    public Patient getPatient(@PathVariable int id)
    {
        return patientService.findById(id);
    }


    //Get all the Patient
    @GetMapping("/getAll")
    public List<Patient> getAllPatient()
    {
        return patientService.findAll();
    }

    //Delete a Patient by ID
    @DeleteMapping("/id/{id}")
    public void deletePatient(@PathVariable int id)
    {
        patientService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public void updatePatient(@PathVariable int id ,@RequestBody Patient thePatient)
    {
        Patient updatePatient = patientService.findById(id);
        if (updatePatient !=null)
        {
            updatePatient.setFirstName(thePatient.getFirstName());
            updatePatient.setLastName(thePatient.getLastName());
            updatePatient.setAge(thePatient.getAge());
            updatePatient.setEmail(thePatient.getEmail());
            updatePatient.setPhone(thePatient.getPhone());
            updatePatient.setAddress(thePatient.getAddress());
            updatePatient.setAppointments(thePatient.getAppointments());

            patientService.update(updatePatient);
        }

    }
}
