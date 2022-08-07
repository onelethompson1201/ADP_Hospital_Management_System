/*  IDepartmentRepository.java
    Interface for the DepartmentRepository
    Author: Chante Lee Davids [220246688]
    Date  : 6 April 2022
*/

package za.ac.cput.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.Entity.Department;

import java.util.Set;

public interface IDepartmentRepository extends JpaRepository<Department, String> {
    public Set<Department> getAll();

}
