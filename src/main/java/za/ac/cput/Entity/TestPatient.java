package za.ac.cput.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 TestPatient.Java
 AUTHOR: Nolubabalo Ndongeni
 Student number: 219319464
 Date: 10 April 2022
 Date: 07 August 2022
 **/

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class TestPatient {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private String testID;
    @NotNull
    private String testName;
    @NotNull
    private String patientID;

    private TestPatient (Builder builder) {
        this.testID = builder.testID;
        this.testName = builder.testName;
        this.patientID = builder.patientID;
    }


    @Override
    public String toString() {
        return "TestPatient{" +
                "testID='" + testID + '\'' +
                ", testName='" + testName + '\'' +
                ", patientID='" + patientID + '\'' +
                '}';
    }

    public static class Builder{
        private String testID;
        private String testName;
        private String patientID;


        public Builder setTestID(String testID) {
            this.testID = testID;
            return this;
        }

        public Builder setTestName(String testName) {
            this.testName = testName;
            return this;
        }

        public Builder setPatientID(String patientID) {
            this.patientID = patientID;
            return this;
        }

        public Builder copy(TestPatient testPatient){
            this.testID = testPatient.testID;
            this.testName = testPatient.testName;
            this.patientID = testPatient.patientID;
            return this;
        }

        public TestPatient build(){
            return new TestPatient(this);
        }
    }

}
