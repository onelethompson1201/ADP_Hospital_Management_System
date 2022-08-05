package za.ac.cput.Entity;

//This is a worker class for Appointment entity under entity package.
//In this class will implement an entity called Appointment using a builder pattern.
//This is Appointment.java


import java.sql.Time;
import java.util.Date;

/**
 * @author Chuma Nxazonke
 * Student number: 219181187
 * Date: 06 April 2022
 */


public class Appointment {
    //Declaring all the fields for the program as private fields

    private String appointmentID;
    private  String doctorID;
    private String appointmentType;
    private   String appointmentDescription;
    private  String appointmentDay;
    private String appointmentMonth;

//Creating a private parametrized constructor

    private Appointment (Builder builder){
        this.appointmentID  = builder.appointmentID;
        this.doctorID = builder.doctorID;
        this.appointmentType = builder.appointmentType;
        this.appointmentDescription = builder.appointmentDescription;
        this.appointmentDay = builder.appointmentDay;
        this.appointmentMonth = builder.appointmentMonth;


    }

    public String getAppointmentID (){
        return appointmentID;
    }

    public void setAppointmentID(String appointmentID1){
        this.appointmentID = appointmentID1;
    }

    public String getDoctorID (){
        return doctorID;
    }

    public void setDoctorID (String doctorID1){
        this.doctorID = doctorID1;
    }

    public String getAppointmentType (){
        return  appointmentType;
    }

    public void setAppointmentType (String appointmentType1){
        this.appointmentType = appointmentType1;
    }

    public String getAppointmentDescription (){
        return appointmentDescription;
    }

    public void setAppointmentDescription (String appointmentDescription1){

        this.appointmentDescription = appointmentDescription1;
    }

    public String getAppointmentDay (){
        return appointmentDay;
    }

    public void setAppointmentDay (String appointmentDay1){

        this.appointmentDay = appointmentDay1;
    }

    public String getAppointmentMonth (){
        return appointmentMonth;

    }

    public void setAppointmentMonth (String appointmentMonth1){
        this.appointmentMonth  = appointmentMonth1;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId='" + appointmentID + '\'' +
                ", doctorId='" + doctorID + '\'' +
                ", appointmentType='" + appointmentType + '\'' +
                ", appointmentDescription='" + appointmentDescription + '\'' +
                ", appointmentDate=" + appointmentDay +
                ", appointmentTime=" + appointmentMonth +
                '}';
    }

    public static class Builder{
        //Declaring all the fields for the program as private fields

        private String appointmentID;
        private  String doctorID;
        private String appointmentType;
        private   String appointmentDescription;
        private  String appointmentDay;
        private String appointmentMonth;


        public Builder setAppointmentId (String appointmentID1){
            this.appointmentID = appointmentID1;
            return this;
        }

        public Builder setDoctorId(String doctorID1){
            this.doctorID = doctorID1;
            return this;
        }

        public Builder setAppointmentType ( String appointmentType1){
            this.appointmentType = appointmentType1;
            return this;
        }

        public Builder setAppointmentDescription(String appointmentDescription1){
            this.appointmentDescription = appointmentDescription1;
            return this;
        }

        public Builder setAppointmentDay(String appointmentDay1){
            this.appointmentDay = appointmentDay1;
            return  this;
        }

        public Builder setAppointmentMonth(String appointmentMonth1){
            this.appointmentMonth = appointmentMonth1;
            return this;
        }


        public Builder Copy (Appointment appointment){

            this.appointmentID = appointment.appointmentID;
            this.doctorID = appointment.doctorID;
            this.appointmentType = appointment.appointmentType;
            this.appointmentDescription = appointment.appointmentDescription;
            this.appointmentDay = appointment.appointmentDay;
            this.appointmentMonth = appointment.appointmentMonth;

            return this;

        }

        public Appointment build(){
            return new Appointment(this);
        }


    }



}