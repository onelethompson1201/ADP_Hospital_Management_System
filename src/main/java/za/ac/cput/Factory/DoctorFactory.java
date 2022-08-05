/*  DoctorFactory.java
    Factory for the Doctor
    Author: Chante Lee Davids [220246688]
    Date  : 6 April 2022
*/

package za.ac.cput.Factory;

import za.ac.cput.Entity.Doctor;
import za.ac.cput.util.Helper;

public class DoctorFactory {

    public static Doctor createDoctor(String doctorName, String doctorPassword,
                                      String departmentName,
                                      String specialty)
    {
        String doctorID = Helper.generateAdministrationID();

        Doctor doctor = new Doctor.Builder().setDoctorID(doctorID)
            .setDoctorName(doctorName)
            .setDoctorPassword(doctorPassword)
            .setDepartmentName(departmentName)
            .setSpecialty(specialty)
            .build();
        return doctor;
    }

}
