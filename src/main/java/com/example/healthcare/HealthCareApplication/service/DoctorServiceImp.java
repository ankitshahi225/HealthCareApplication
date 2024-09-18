package com.example.healthcare.HealthCareApplication.service;

import com.example.healthcare.HealthCareApplication.entity.Doctor;
import com.example.healthcare.HealthCareApplication.repository.DoctorDAORepos;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImp  implements DoctorService{

    private DoctorDAORepos theDoctorRepo;
    public DoctorServiceImp(){}

    @Autowired
    public DoctorServiceImp(DoctorDAORepos theDoctorRepo)
    {
        this.theDoctorRepo = theDoctorRepo;
    }

    @Override
    @Transactional
    public Doctor save(Doctor doctor)
    {
        return theDoctorRepo.save(doctor);

    }

    @Override
    public Doctor findById(int id) {
        return theDoctorRepo.findById(id);
    }

    @Override
    public List<Doctor> findAll() {
        return theDoctorRepo.findAll();
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        theDoctorRepo.deleteById(id);
    }

    @Override
    @Transactional
    public void update(Doctor doctor) {
        theDoctorRepo.update(doctor);
    }
}
