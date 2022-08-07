package za.ac.cput.Entity;

import javax.persistence.*;

/**
 TestPatient.Java
 AUTHOR: Nolubabalo Ndongeni
 Student number: 219319464
 Date: 10 April 2022
 Date: 07 August 2022
 **/

@Entity
public class TestPatient {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private String testID;
    private String testName;
    @EmbeddedId
    private String patientID;

    private TestPatient (Builder builder) {
        this.testID = builder.testID;
        this.testName = builder.testName;
        this.patientID = builder.patientID;
    }

    public TestPatient() {

    }

    public String getTestID() {
        return testID;
    }

    public String getTestName() {
        return testName;
    }

    public String getPatientID() {
        return patientID;
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
