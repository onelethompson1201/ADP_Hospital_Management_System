package za.ac.cput.Service.Interfaces;

import za.ac.cput.Entity.Patient;
import za.ac.cput.Service.IService;

import java.util.List;
/*
IPatientService
Name: Nolubabalo Ndongeni
Student number: 219319464
Date: 13 August 2022
 */

public interface IPatientService extends IService<Patient, String> {
    List<Patient> getPatients();
    Patient getPatientByName(String patientName);

}
