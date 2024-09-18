package com.example.healthcare.HealthCareApplication.repository;

import com.example.healthcare.HealthCareApplication.entity.Appointment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppointmentRepository implements AppointmentDAORepo{

    private final EntityManager manager;



    @Autowired
    public AppointmentRepository(EntityManager manager)
    {
        this.manager = manager;
    }

    @Override
    @Transactional
    public Appointment save(Appointment appointment) {
        manager.persist(appointment);
        return appointment;
    }

    @Override
    public Appointment findById(int id) {
        return manager.find(Appointment.class,id);
    }

    @Override
    public List<Appointment> findAll() {
        Query appointments = manager.createQuery("SELECT a FROM Appointment a");
        return appointments.getResultList();
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Appointment foundAppointment = manager.find(Appointment.class,id);
        if(foundAppointment != null)
        {
            manager.remove(foundAppointment);
        }
    }

    @Override
    @Transactional
    public void update(Appointment appointment) {
        manager.merge(appointment);
    }
}
