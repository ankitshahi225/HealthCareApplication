package com.example.healthcare.HealthCareApplication.repository;

import com.example.healthcare.HealthCareApplication.entity.Doctor;

import java.util.List;

public interface DoctorDAORepos {

    public Doctor save(Doctor doctor);
    public Doctor findById(int id);
    public List<Doctor> findAll();
    public void deleteById(int id);
    public void update(Doctor doctor);
}
