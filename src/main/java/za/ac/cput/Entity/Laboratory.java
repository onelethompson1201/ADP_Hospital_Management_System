package za.ac.cput.Entity;

//This is a worker class for laboratory entity under entity package.
//In this class will implement an entity called Laboratory using a builder pattern.
//This is Laboratory.java

import java.util.Date;

/**
 *
 * @author Chuma Nxazonke
 * Student number: 219181187
 * Date: 06 April 2022
 */



public class Laboratory {
//Declaring all the  private fields we are going to use on our program

    private String labID;
    private String patientID;
    private String doctorID;
    private String patientTestID;
    private String labName;
    private String labDay;
    private double amount;


//Creating a private parameterized constructor

    private Laboratory (Builder builder){

        this.labID  = builder.labID;
        this.doctorID = builder.doctorID;
        this.patientID = builder.patientID;
        this.patientTestID = builder.patientTestID;
        this.labName = builder.labName;
        this.labDay = builder.labDay;
        this.amount = builder.amount;


    }

    public String getLabID() {
        return labID;
    }

    public String getPatientID() {
        return patientID;
    }

    public String getDoctorId() {
        return doctorID;
    }

    public String getPatientTestID() {
        return patientTestID;
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

    public void setLabId(String labID1) {
        this.labID = labID1;
    }

    public void setPatientID(String patientID1) {
        this.patientID = patientID1;
    }

    public void setDoctorID(String doctorID1) {
        this.doctorID = doctorID1;
    }

    public void setPatientTestID(String patientTestID1) {
        this.patientTestID = patientTestID1;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public void setLabDay(String labDay1) {
        this.labDay = labDay1;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Laboratory{" +
                "labId='" + labID + '\'' +
                ", patientId='" + patientID + '\'' +
                ", doctorId='" + doctorID + '\'' +
                ", patientTestId='" + patientTestID + '\'' +
                ", labName='" + labName + '\'' +
                ", labDate=" + labDay +
                ", amount=" + amount +
                '}';
    }

    public static class Builder{

        private String labID;
        private String patientID;
        private String doctorID;
        private String patientTestID;
        private String labName;
        private String labDay;
        private double amount;


        public Builder setLabID (String labID1){
            this.labID = labID1;
            return this;
        }
        public Builder setPatientID (String patientID1){
            this.patientID = patientID1;
            return this;
        }

        public Builder setDoctorId (String doctorID1){
            this.doctorID = doctorID1;
            return this;
        }

        public Builder setPatientTestID (String testID1){
            this.patientTestID = testID1;
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
            this.patientID = laboratory.patientID;
            this.doctorID = laboratory.doctorID;
            this.patientTestID = laboratory.patientTestID;
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