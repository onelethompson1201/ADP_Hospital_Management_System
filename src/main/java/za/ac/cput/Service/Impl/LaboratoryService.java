package za.ac.cput.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.ac.cput.Entity.Appointment;
import za.ac.cput.Entity.Laboratory;
import za.ac.cput.Repository.ILaboratoryRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Chuma Nxazonke
 * Student number: 219181187
 * Date: 15 August 2022
 */
@Service
public class LaboratoryService  {

    private final ILaboratoryRepository repository;

    @Autowired
    public LaboratoryService (ILaboratoryRepository iLaboratoryRepository){
        this.repository = iLaboratoryRepository;
    }


    public Laboratory saveLaboratory (Laboratory laboratory){
        return this.repository.save(laboratory);
    }

    public List<Laboratory> saveLaboratory (List<Laboratory> laboratoryList){
        return  this.repository.saveAll(laboratoryList);
    }

    public Laboratory readLaboratory (String labID){
        return this.repository.getById(labID);
    }


    public boolean deleteLaboratory (String labID){

        if(this.repository.existsById(labID)){
            this.repository.deleteById(labID);

            return true;
        }
        return false;
    }
    public Laboratory updateLaboratory (Laboratory laboratory) {
        Laboratory existLaboratory = repository.findById(laboratory.getLabID()).orElse(null);
        existLaboratory.setDoctor(laboratory.getDoctor());
        existLaboratory.setPatient(laboratory.getPatient());
        existLaboratory.setTestPatient(laboratory.getTestPatient());
        existLaboratory.setLabName(laboratory.getLabName());
        existLaboratory.setLabDay(laboratory.getLabDay());
        existLaboratory.setAmount(laboratory.getAmount());


        return this.repository.save(existLaboratory);

    }

    public List<Laboratory> getAllLaboratory() {
        return this.repository.findAll();
    }




}
