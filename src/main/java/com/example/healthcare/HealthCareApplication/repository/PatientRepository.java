package com.example.healthcare.HealthCareApplication.repository;


import com.example.healthcare.HealthCareApplication.entity.Patient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PatientRepository implements PatientDAORepo {

    private final EntityManager manager;

    @Autowired
    public PatientRepository(EntityManager manager)
    {
        this.manager = manager;
    }


    @Override
    @Transactional
    public Patient save(Patient patient) {
        manager.persist(patient);
        return patient;
    }

    @Override
    public Patient findById(int id) {
        return manager.find(Patient.class,id);
    }

    @Override
    public List<Patient> findAll() {
        Query allPatient = manager.createQuery("SELECT p FROM Patient p");
        return allPatient.getResultList();
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Patient foundPatient = manager.find(Patient.class,id);
        if(foundPatient != null) {
            manager.remove(foundPatient);
        }
    }

    @Override
    @Transactional
    public void update(Patient patient) {
        manager.merge(patient);
    }
}
