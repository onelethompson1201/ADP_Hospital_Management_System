/*  IDoctorRepository.java
    Interface for the DoctorRepository
    Author: Chante Lee Davids [220246688]
    Date  : 6 April 2022
*/

package za.ac.cput.Repository;

import za.ac.cput.Entity.Doctor;

import java.util.Set;

public interface IDoctorRepository extends IRepository <Doctor, String>{
    public Set<Doctor> getAll();
}
