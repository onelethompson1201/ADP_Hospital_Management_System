/*  DepartmentRepository.java
    Repository for the Department
    Author: Chante Lee Davids [220246688]
    Date  : 6 April 2022
*/

package za.ac.cput.Repository;

import za.ac.cput.Entity.Department;

import java.util.HashSet;
import java.util.Set;

public class DepartmentRepository implements IDepartmentRepository {

    private static DepartmentRepository repository = null;
    private Set<Department> departmentDB = null;

    private DepartmentRepository()
    {
        departmentDB = new HashSet<Department>();
    }

    public static DepartmentRepository getRepository()
    {
        if (repository == null)
        {
            repository = new DepartmentRepository();
        }
        return repository;
    }

    @Override
    public Department create(Department department)
    {
        boolean success = departmentDB.add(department);
        if(!success)
        {
            return null;
        }
        return department;
    }


    @Override
    public Department read(String departmentID)
    {
        Department department = departmentDB.stream()
                .filter(e -> e.getDepartmentID().equals(departmentID))
                .findAny()
                .orElse(null);
        return department;

    }

    @Override
    public Department update(Department department)
    {
        Department oldDepartment = read(department.getDepartmentID());
        if(oldDepartment != null)
        {
            departmentDB.remove(oldDepartment);
            departmentDB.add(department);
            return department;
        }
        return null;
    }

    @Override
    public boolean delete(String departmentID)
    {
        Department departmentToDelete = read(departmentID);
        if(departmentToDelete == null)
        {
            return false;
        }
        departmentDB.remove(departmentToDelete);
        return true;
    }

    @Override
    public Set<Department> getAll()
    {
        return departmentDB;
    }

}
