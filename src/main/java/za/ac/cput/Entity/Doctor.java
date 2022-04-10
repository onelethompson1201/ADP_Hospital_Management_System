/*  Doctor.java
    Entity for the Doctor
    Author: Chante Lee Davids [220246688]
    Date  : 6 April 2022
*/

package za.ac.cput.Entity;

public class Doctor {
    private String doctorID;
    private String doctorName;
    private String doctorPassword;
    private String departmentName;
    private String specialty;

    private Doctor(Builder builder){
        this.doctorID = builder.doctorID;
        this.doctorName = builder.doctorName;
        this.doctorPassword = builder.doctorPassword;
        this.departmentName = builder.departmentName;
        this.specialty = builder.specialty;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorPassword() {
        return doctorPassword;
    }

    public void setDoctorPassword(String doctorPassword) {
        this.doctorPassword = doctorPassword;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorID='" + doctorID + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", doctorPassword='" + doctorPassword + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", specialty='" + specialty + '\'' +
                '}';
    }

    public static class Builder{
        private String doctorID;
        private String doctorName;
        private String doctorPassword;
        private String departmentName;
        private String specialty;

        public Builder setDoctorID(String doctorID) {
            this.doctorID = doctorID;
            return this;
        }

        public Builder setDoctorName(String doctorName) {
            this.doctorName = doctorName;
            return this;
        }

        public Builder setDoctorPassword(String doctorPassword) {
            this.doctorPassword = doctorPassword;
            return this;
        }

        public Builder setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
            return this;
        }

        public Builder setSpecialty(String specialty) {
            this.specialty = specialty;
            return this;
        }

        public Builder copy(Doctor doctor){
            this.doctorID = doctor.doctorID;
            this.doctorName = doctor.doctorName;
            this.doctorPassword = doctor.doctorPassword;
            this.departmentName = doctor.departmentName;
            this.specialty = doctor.specialty;
            return this;
        }

        public Doctor build(){
            return new Doctor(this);
        }
    }

}
