/*
    Author: Duncan Benjamin Harris
    Student Number: 220110530
    14/08/2022
*/
package za.ac.cput.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.Entity.Administration;
import za.ac.cput.Repository.IAdministrationRepository;
import za.ac.cput.Service.Interfaces.IAdministrationService;

import java.util.List;

public class AdministrationService implements IAdministrationService
{
    private final IAdministrationRepository repository;

    @Autowired
    public AdministrationService(IAdministrationRepository administrationRepository)
    {
        this.repository = administrationRepository;
    }

    @Override
    public Administration save(Administration administration)
    {
        return this.repository.save(administration);
    }

    @Override
    public Administration read(String adminID) {
        return this.repository.getById(adminID);
    }

    @Override
    public void delete(String adminID) {
        this.repository.deleteById(adminID);
    }

    @Override
    public List<Administration> getAll()
    {
        return this.repository.findAll();
    }
}
