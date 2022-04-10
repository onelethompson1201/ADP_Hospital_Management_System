package za.ac.cput.Repository;

import za.ac.cput.Entity.Patient;

import java.util.Set;
/**
 IPatientRepository.Java
 AUTHOR: Nolubabalo Ndongeni
 Student number: 219319464
 Date: 10 April 2022
 **/

public interface IPatientRepository extends IRepository<Patient, String>{
    public Set<Patient> getAll();


}
