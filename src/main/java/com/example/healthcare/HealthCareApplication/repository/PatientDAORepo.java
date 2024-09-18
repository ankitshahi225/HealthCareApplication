package com.example.healthcare.HealthCareApplication.repository;
import com.example.healthcare.HealthCareApplication.entity.Patient;

import java.util.List;

public interface PatientDAORepo {

    public Patient save(Patient patient);
    public Patient findById(int id);
    public List<Patient> findAll();
    public void deleteById(int id);
    public void update(Patient patient);
}
