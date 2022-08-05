package za.ac.cput.Repository;

import za.ac.cput.Entity.TestPatient;

import java.util.Set;
/**
 ITestPatientRepository.Java
 AUTHOR: Nolubabalo Ndongeni
 Student number: 219319464
 Date: 10 April 2022
 **/

public interface ITestPatientRepository extends IRepository<TestPatient, String> {
    public Set<TestPatient> getAll();
}
