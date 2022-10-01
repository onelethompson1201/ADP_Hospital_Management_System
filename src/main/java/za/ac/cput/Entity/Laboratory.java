package za.ac.cput.Entity;

//This is a worker class for laboratory entity under entity package.
//In this class will implement an entity called Laboratory using a builder pattern.
//This is Laboratory.java

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 *
 * @author Chuma Nxazonke
 * Student number: 219181187
 * Date: 06 April 2022
 */

@Setter
@Getter

@AllArgsConstructor
@Table
@Entity

public class Laboratory {
//Declaring all the  private fields we are going to use on our program

    @Id
    @Column(name = "labID")

    private String labID;

    @NotNull
    private String patient;

    @NotNull
    private String doctor;

    @NotNull
    private String testPatient;
    @NotNull
    private String labName;
    @NotNull
    private String labDay;
    @NotNull
    private double amount;

    protected Laboratory(){

    }

//Creating a private parameterized constructor

    private Laboratory (Builder builder){

        this.labID  = builder.labID;
        this.doctor = builder.build().doctor;
        this.patient = builder.build().patient;
        this.testPatient = builder.build().testPatient;
        this.labName = builder.labName;
        this.labDay = builder.labDay;
        this.amount = builder.amount;


    }

    public String getLabID() {
        return labID;
    }

    public String getPatient() {
        return patient;
    }

    public String getDoctor() {
        return doctor;
    }

    public String getTestPatient() {
        return testPatient;
    }

    public String getLabName() {
        return labName;
    }

    public String getLabDay() {
        return labDay;
    }

    public double getAmount() {
        return amount;
    }



    @Override
    public String toString() {
        return "Laboratory{" +
                "labId='" + labID + '\'' +
                ", patientId='" + patient + '\'' +
                ", doctorId='" + doctor + '\'' +
                ", patientTestId='" + testPatient + '\'' +
                ", labName='" + labName + '\'' +
                ", labDate=" + labDay +
                ", amount=" + amount +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laboratory laboratory = (Laboratory) o;
        return labID.equals(laboratory.labID) && patient.equals(laboratory.patient)
                && doctor.equals(laboratory.doctor) && testPatient.equals(laboratory.testPatient)
                && labName.equals(laboratory.labName) && labDay.equals(laboratory.labDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(labID);
    }




    public static class Builder{

        private String labID;
        private String patient;
        private String doctor;
        private String testPatient;
        private String labName;
        private String labDay;
        private double amount;


        public Builder setLabID (String labID1){
            this.labID = labID1;
            return this;
        }
        public Builder setPatient (String patient){
            this.patient = patient;
            return this;
        }

        public Builder setDoctor (String doctor){
            this.doctor = doctor;
            return this;
        }

        public Builder setTestPatient (String testPatient){
            this.testPatient = testPatient;
            return this;
        }

        public Builder setLabName (String labName1){
            this.labName = labName1;
            return this;
        }

        public Builder setLabDay (String labDay1){
            this.labDay = labDay1;
            return this;
        }

        public Builder setAmount (double amount1){
            this.amount = amount1;
            return this;
        }

        public Builder Copy (Laboratory laboratory){

            this.labID = laboratory.labID;
            this.patient = laboratory.patient;
            this.doctor = laboratory.doctor;
            this.testPatient = laboratory.testPatient;
            this.labName = laboratory.labName;
            this.labDay = laboratory.labDay;
            this.amount = laboratory.amount;

            return this;
        }


        public Laboratory build(){
            return new Laboratory(this);
        }

    }

}