/*  Doctor.java
    Entity for the Doctor
    Author: Chante Lee Davids [220246688]
    Date  : 6 August 2022
*/

package za.ac.cput.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Doctor implements Serializable {

    @Id
    private String doctorID;

    private String doctorName;
    private String doctorPassword;

    @OneToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    private Department department;

    private String specialty;

    protected Doctor() {
    }

    private Doctor(Builder builder){
        this.doctorID = builder.doctorID;
        this.doctorName = builder.doctorName;
        this.doctorPassword = builder.doctorPassword;
        this.department = builder.department;
        this.specialty = builder.specialty;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getDoctorPassword() {
        return doctorPassword;
    }

    public Department getDepartment() {
        return department;
    }

    public String getSpecialty() {
        return specialty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(doctorID, doctor.doctorID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorID);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorID='" + doctorID + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", doctorPassword='" + doctorPassword + '\'' +
                ", department='" + department + '\'' +
                ", specialty='" + specialty + '\'' +
                '}';
    }

    public static class Builder{
        private String doctorID;
        private String doctorName;
        private String doctorPassword;
        private Department department;
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

        public Builder setDepartment(Department department) {
            this.department = department;
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
            this.department = doctor.department;
            this.specialty = doctor.specialty;
            return this;
        }

        public Doctor build(){
            return new Doctor(this);
        }
    }

}