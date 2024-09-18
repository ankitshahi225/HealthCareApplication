package com.example.healthcare.HealthCareApplication.service;

import com.example.healthcare.HealthCareApplication.entity.Patient;
import com.example.healthcare.HealthCareApplication.repository.PatientDAORepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImp implements PatientService{


    private PatientDAORepo patientRepository;

    public PatientServiceImp(){}

    @Autowired
    public PatientServiceImp(PatientDAORepo patientRepository)
    {
        this.patientRepository = patientRepository;
    }

    @Override
    @Transactional
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient findById(int id) {
        return patientRepository.findById(id);
    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        patientRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(Patient patient) {
        patientRepository.update(patient);
    }
}
