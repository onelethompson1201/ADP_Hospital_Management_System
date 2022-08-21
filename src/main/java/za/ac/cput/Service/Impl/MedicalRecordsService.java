/*
    Author: Duncan Benjamin Harris
    Student Number: 220110530
    14/08/2022
*/
package za.ac.cput.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.MedicalRecords;
import za.ac.cput.Repository.IMedicalRecordsRepository;
import za.ac.cput.Service.Interfaces.IMedicalRecordsService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
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
        return this.repository.findById(recordID).orElse(null);
    }

    @Override
    public boolean delete(String recordID)
    {
        if(this.repository.existsById(recordID))
        {
            this.repository.deleteById(recordID);
            return true;
        }
        return false;
    }

    @Override
    public Set<MedicalRecords> getAll()
    {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
