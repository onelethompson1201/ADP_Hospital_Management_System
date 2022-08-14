/*
DoctorService
Name: Chante Lee Davids
Student number: 220246688
Date: 13 August 2022
 */

package za.ac.cput.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.Entity.Doctor;
import za.ac.cput.Repository.IDoctorRepository;
import za.ac.cput.Service.Interfaces.IDoctorService;

import java.util.List;

public class DoctorService implements IDoctorService {

    private final IDoctorRepository repository;

    @Autowired
    public DoctorService(IDoctorRepository iDoctorRepository){
        this.repository = iDoctorRepository;
    }

    @Override
    public Doctor save(Doctor doctor) {
        return repository.save(doctor);
    }

    @Override
    public Doctor read(String doctorId) {
        return repository.findById(doctorId).orElse(null);
    }

    @Override
    public void delete(String doctorId) {
        repository.deleteById(doctorId);
    }

    @Override
    public List<Doctor> getDoctors() {
        return repository.findAll();
    }
}
