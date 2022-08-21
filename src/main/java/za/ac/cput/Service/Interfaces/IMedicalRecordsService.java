/*
    Author: Duncan Benjamin Harris
    Student Number: 220110530
    14/08/2022
*/
package za.ac.cput.Service.Interfaces;

import za.ac.cput.Entity.MedicalRecords;
import za.ac.cput.Service.IService;

import java.util.List;
import java.util.Set;

public interface IMedicalRecordsService extends IService<MedicalRecords, String>
{
    Set<MedicalRecords> getAll();
}
