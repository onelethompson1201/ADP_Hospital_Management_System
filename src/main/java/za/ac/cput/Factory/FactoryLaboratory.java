package za.ac.cput.Factory;

//This is a worker class for laboratory entity under factory package.
//In this class will implement an entity called Laboratory using a factory pattern.
//This is Laboratory.java

import za.ac.cput.Entity.Laboratory;


import za.ac.cput.util.Helper;
/**
 *
 * @author Chuma Nxazonke
 * Student number: 219181187
 * Date: 07 April 2022
 */

public class FactoryLaboratory {

    public static Laboratory createLaboratory(String labName, String labDay, double amount){

        String labID = Helper.generateLaboratoryID();
        String patientID = Helper.generatePatientID();
        String doctorID = Helper.generateDoctorID();
        String testPatientID = Helper.generateTestID();


        if (Helper.isNullorEmpty(labName) || Helper.isNullorEmpty(labDay))
            return null;


        Laboratory laboratory = new Laboratory.Builder().setLabID(labID)
                .setPatientID(patientID)
                .setDoctorId(doctorID)
                .setPatientTestID(testPatientID)
                .setLabName(labName)
                .setLabDay(labDay)
                .setAmount(amount)
                .build();

        return  laboratory;

    }

}
