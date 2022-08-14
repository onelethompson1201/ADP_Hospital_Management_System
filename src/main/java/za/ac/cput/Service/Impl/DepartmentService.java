/*
DepartmentService
Name: Chante Lee Davids
Student number: 220246688
Date: 13 August 2022
 */

package za.ac.cput.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.Entity.Department;
import za.ac.cput.Repository.IDepartmentRepository;
import za.ac.cput.Service.Interfaces.IDepartmentService;

import java.util.List;

public class DepartmentService implements IDepartmentService {

    private final IDepartmentRepository repository;

    @Autowired
    public DepartmentService(IDepartmentRepository iDepartmentRepository){
        this.repository = iDepartmentRepository;
    }

    @Override
    public Department save(Department department) {
        return repository.save(department);
    }

    @Override
    public Department read(String departmentId) {
        return repository.findById(departmentId).orElse(null);
    }

    @Override
    public void delete(String departmentId) {
        repository.deleteById(departmentId);
    }

    @Override
    public List<Department> getDepartments() {
        return repository.findAll();
    }
}
