package com.example.healthcare.HealthCareApplication.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime appointmentTime;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    public Appointment(){}

    public Appointment(LocalDateTime appointmentTime, Patient patient, Doctor doctor) {
        this.appointmentTime = appointmentTime;
        this.patient = patient;
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", appointmentTime=" + appointmentTime +
                ", patient=" + patient +
                ", doctor=" + doctor +
                '}';
    }
}
