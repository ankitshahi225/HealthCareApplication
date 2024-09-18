package com.example.healthcare.HealthCareApplication.service;

import com.example.healthcare.HealthCareApplication.entity.Doctor;

import java.util.List;

public interface DoctorService {
    public Doctor save(Doctor doctor);
    public Doctor findById(int id);
    public List<Doctor> findAll();
    public void deleteById(int id);
    public void update(Doctor doctor);
}
