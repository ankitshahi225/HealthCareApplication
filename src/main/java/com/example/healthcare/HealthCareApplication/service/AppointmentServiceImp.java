package com.example.healthcare.HealthCareApplication.service;


import com.example.healthcare.HealthCareApplication.entity.Appointment;
import com.example.healthcare.HealthCareApplication.repository.AppointmentDAORepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImp implements  AppointmentService{

    private AppointmentDAORepo appointmentRepository;

    public AppointmentServiceImp(){}

    @Autowired
    public AppointmentServiceImp(AppointmentDAORepo appointmentRepository){
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    @Transactional
    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment findById(int id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(Appointment appointment) {
        appointmentRepository.update(appointment);
    }
}
