package com.example.healthcare.HealthCareApplication.repository;

import com.example.healthcare.HealthCareApplication.entity.Appointment;
import java.util.List;

public interface AppointmentDAORepo {

    public Appointment save(Appointment appointment);
    public Appointment findById(int id);
    public List<Appointment> findAll();
    public void deleteById(int id);
    public void update(Appointment appointment);
}
