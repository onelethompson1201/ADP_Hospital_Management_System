package za.ac.cput.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Doctor;
import za.ac.cput.Entity.Laboratory;
import za.ac.cput.Repository.ILaboratoryRepository;
import za.ac.cput.Service.Interfaces.ILaboratoryService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Chuma Nxazonke
 * Student number: 219181187
 * Date: 15 August 2022
 */
@Service
public class LaboratoryService implements ILaboratoryService {

    private final ILaboratoryRepository repository;

    @Autowired
    public LaboratoryService (ILaboratoryRepository iLaboratoryRepository){
        this.repository = iLaboratoryRepository;
    }

    @Override
    public Laboratory save(Laboratory laboratory) {
        return repository.save(laboratory);
    }

    @Override
    public Laboratory read(String labId) {
        return this.repository.getById(labId);
    }

    @Override
    public boolean delete(String labId) {
        if(this.repository.existsById(labId)){
            this.repository.deleteById(labId);
            return true;
        }
        return false;
    }

    @Override
    public Set<Laboratory> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }









}
