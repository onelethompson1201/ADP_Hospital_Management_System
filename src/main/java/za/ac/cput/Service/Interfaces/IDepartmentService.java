/*
IDepartmentService
Name: Chante Lee Davids
Student number: 220246688
Date: 13 August 2022
 */

package za.ac.cput.Service.Interfaces;

import za.ac.cput.Entity.Department;
import za.ac.cput.Service.IService;

import java.util.List;

public interface IDepartmentService extends IService<Department, String>{
    List<Department> getDepartments();
}
