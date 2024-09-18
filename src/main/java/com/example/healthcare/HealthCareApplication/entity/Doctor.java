package com.example.healthcare.HealthCareApplication.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private  String lastName;
    private String specialization;
    private String email;
    private long phone;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    //No argument constructor
    public Doctor(){}

    //Argument Constructor

    public Doctor(String firstName, String lastName, String specialization, String email, long phone, List<Appointment> appointments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
        this.email = email;
        this.phone = phone;
        this.appointments = appointments;
    }


    //Getters and Setters method

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialization='" + specialization + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", appointments=" + appointments +
                '}';
    }
}
