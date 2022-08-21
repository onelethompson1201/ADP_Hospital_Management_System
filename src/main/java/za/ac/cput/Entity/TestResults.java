/* TestResults.java
 Entity for the TestResults
 Author: Onele Tomson (219483280)
 Date: 08 May 2022
*/

package za.ac.cput.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TestResults {

    private String patientName;
    private String patientSex;

    @Id
    private String testID;
    private String testDate;
    private String testDescription;

    protected TestResults(){}

    private TestResults(Builder builder) {
        this.patientName = builder.patientName;
        this.patientSex = builder.patientSex;
        this.testID = builder.testID;
        this.testDate = builder.testDate;
        this.testDescription = builder.testDescription;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getPatientSex() {
        return patientSex;
    }

    public String getTestID() {
        return testID;
    }

    public String getTestDate() {
        return testDate;
    }

    public String getTestDescription() {
        return testDescription;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setPatientSex(String patientSex) {
        this.patientSex = patientSex;
    }

    public void setTestID(String testID) {
        this.testID = testID;
    }

    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    public void setTestDescription(String testDescription) {
        this.testDescription = testDescription;
    }

    @Override
    public String toString() {
        return "TestResults{" +
                "patientName='" + patientName + '\'' +
                ", patientSex='" + patientSex + '\'' +
                ", testID='" + testID + '\'' +
                ", testDate='" + testDate + '\'' +
                ", testDescription='" + testDescription + '\'' +
                '}';
    }

    public static class Builder {
        private String patientName;
        private String patientSex;
        private String testID;
        private String testDate;
        private String testDescription;

        public Builder setPatientName(String patientName) {
            this.patientName = patientName;
            return this;
        }

        public Builder setPatientSex(String patientSex) {
            this.patientSex = patientSex;
            return this;
        }

        public Builder setTestID(String testID) {
            this.testID = testID;
            return this;
        }

        public Builder setTestDate(String testDate) {
            this.testDate = testDate;
            return this;
        }

        public Builder setTestDescription(String testDescription) {
            this.testDescription = testDescription;
            return this;
        }

        public Builder copy(TestResults testresults) {
            this.patientName = testresults.patientName;
            this.patientSex = testresults.patientSex;
            this.testDate = testresults.testDate;
            this.testDescription = testresults.testDescription;
            return this;
        }
        public TestResults build() {
            return new TestResults(this);
        }
    }
}