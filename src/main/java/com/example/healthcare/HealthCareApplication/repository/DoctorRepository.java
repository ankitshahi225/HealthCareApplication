package com.example.healthcare.HealthCareApplication.repository;

import com.example.healthcare.HealthCareApplication.entity.Doctor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoctorRepository implements DoctorDAORepos{


    private final EntityManager manager;



    @Autowired
    public DoctorRepository(EntityManager manager)
    {
        this.manager = manager;
    }

    @Override
    @Transactional
    public Doctor save(Doctor doctor) {
        manager.persist(doctor);
        return doctor;
    }


    @Override
    public Doctor findById(int id) {
        return manager.find(Doctor.class,id);
    }

    @Override
    public List<Doctor> findAll() {
       Query allDoctor = manager.createQuery("SELECT d FROM Doctor d");
       return allDoctor.getResultList();
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Doctor foundDoctor =manager.find(Doctor.class,id);
        if(foundDoctor != null) {
            manager.remove(foundDoctor);
        }
    }

    @Override
    @Transactional
    public void update(Doctor doctor) {
        manager.merge(doctor);
    }
}
