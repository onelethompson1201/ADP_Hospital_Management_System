/*
    Author: Duncan Benjamin Harris
    Student Number: 220110530
    14/08/2022
*/
package za.ac.cput.Service.Interfaces;

import za.ac.cput.Entity.MedicalRecords;
import za.ac.cput.Service.IService;

import java.util.List;

public interface IMedicalRecordsService extends IService<MedicalRecords, String>
{
    List<MedicalRecords> getAll();
}
