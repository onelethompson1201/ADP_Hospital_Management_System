/*
    Author: Duncan Benjamin Harris
    Student Number: 220110530
    14/08/2022
*/
package za.ac.cput.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.Entity.MedicalRecords;
import za.ac.cput.Repository.IMedicalRecordsRepository;
import za.ac.cput.Service.Interfaces.IMedicalRecordsService;

import java.util.List;

public class MedicalRecordsService implements IMedicalRecordsService
{
    private final IMedicalRecordsRepository repository;

    @Autowired
    public MedicalRecordsService(IMedicalRecordsRepository medicalRecordsRepository)
    {
        this.repository = medicalRecordsRepository;
    }

    @Override
    public MedicalRecords save(MedicalRecords medicalRecords) {
        return this.repository.save(medicalRecords);
    }

    @Override
    public MedicalRecords read(String recordID) {
        return this.repository.getById(recordID);
    }

    @Override
    public void delete(String recordID)
    {
        this.repository.deleteById(recordID);
    }

    @Override
    public List<MedicalRecords> getAll()
    {
        return this.repository.findAll();
    }
}
