/*  DoctorRepository.java
    Repository for the Doctor
    Author: Chante Lee Davids [220246688]
    Date  : 6 April 2022
*/

package za.ac.cput.Repository;

import za.ac.cput.Entity.Doctor;

import java.util.HashSet;
import java.util.Set;

public class DoctorRepository implements IDoctorRepository{

    private static DoctorRepository repository = null;
    private Set<Doctor> doctorDB = null;

    private DoctorRepository(){
        doctorDB = new HashSet<Doctor>();
    }

    public static DoctorRepository getRepository(){
        if (repository == null) {
            repository = new DoctorRepository();
        }
        return repository;
    }

    @Override
    public Doctor create(Doctor doctor) {
        boolean success = doctorDB.add(doctor);
        if(!success) {
            return null;
        }
        return doctor;
    }

    @Override
    public Doctor read(String doctorId) {
        Doctor doctor = doctorDB.stream()
                .filter(e -> e.getDoctorID().equals(doctorId))
                .findAny()
                .orElse(null);
        return doctor;
    }

    @Override
    public Doctor update(Doctor doctor) {
        Doctor oldDoctor = read(doctor.getDoctorID());
        if(oldDoctor != null){
            doctorDB.remove(oldDoctor);
            doctorDB.add(doctor);
            return doctor;
        }
        return null;
    }

    @Override
    public boolean delete(String doctorID) {
        Doctor doctorToDelete = read(doctorID);
        if(doctorToDelete == null) {
            return false;
        }
        doctorDB.remove(doctorToDelete);
        return true;
    }

    @Override
    public Set<Doctor> getAll() {
        return doctorDB;
    }
}
