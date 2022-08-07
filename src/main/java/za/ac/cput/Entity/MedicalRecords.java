/* MedicalRecords.java
   Entity for the medicalRecords(220110530)
   Author: Duncan Benjamin Harris
   Date: 08 April 2022 
*/
package za.ac.cput.Entity;

public class MedicalRecords 
{
    private String recordID;
    private String patientID;
    private String patientName;
    private int patientAge;
    private String patientSex;
    private String testResults;

    private MedicalRecords(Builder builder)
    {
       this.recordID = builder.recordID;
       this.patientID = builder.patientID;
       this.patientName = builder.patientName;
       this.patientAge = builder.patientAge;
       this.patientSex = builder.patientSex;
       this.testResults = builder.testResults;
            
    }
    
    public String getRecordID() {
        return recordID;
    }

    public String getPatientID() {
        return patientID;
    }

    public String getPatientName() {
        return patientName;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public String getPatientSex() {
        return patientSex;
    }

    public String getTestResults() {
        return testResults;
    }

    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public void setPatientSex(String patientSex) {
        this.patientSex = patientSex;
    }

    public void setTestResults(String testResults) {
        this.testResults = testResults;
    }

    @Override
    public String toString() {
        return "MedicalRecords{" + "recordID=" + recordID + ", patientID=" + patientID + ", patientName=" + patientName + ", patientAge=" + patientAge + ", patientSex=" + patientSex + ", testResults=" + testResults + '}';
    }
    
    public static class Builder
    {
        private String recordID;
        private String patientID;
        private String patientName;
        private int patientAge;
        private String patientSex;
        private String testResults;

        public Builder setRecordID(String recordID) {
            this.recordID = recordID;
            return this;
        }

        public Builder setPatientID(String patientID) {
            this.patientID = patientID;
            return this;
        }

        public Builder setPatientName(String patientName) {
            this.patientName = patientName;
            return this;
        }

        public Builder setPatientAge(int patientAge) {
            this.patientAge = patientAge;
            return this;
        }

        public Builder setPatientSex(String patientSex) {
            this.patientSex = patientSex;
            return this;
        }

        public Builder setTestResults(String testResults) {
            this.testResults = testResults;
            return this;
        }
        
        public Builder copy(MedicalRecords medicalrecords)
        {
            this.recordID = medicalrecords.recordID;
            this.patientID = medicalrecords.patientID;
            this.patientName = medicalrecords.patientName;
            this.patientAge = medicalrecords.patientAge;
            this.patientSex = medicalrecords.patientSex;
            this.testResults = medicalrecords.testResults;
            
            return this;
        }
        
        public MedicalRecords build()
        {
            return new MedicalRecords(this);
        }
    }
}
