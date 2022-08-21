package za.ac.cput.Entity;
/* Bill.java
   Entity for the Bill(220021333)
   Author: Davin Shaun Carstens
   Date: 08 April 2022
*/
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Bill
{
    @Id
    @Column(name = "patient_id")
    private String patientID;
    @NotNull
    private String billNo;
    @NotNull
    private String patientName;
    @NotNull
    private float billAmount;
    protected Bill() {
    }

    public Bill(Builder builder)
    {
        this.billNo = builder.billNo;
        this.patientID = builder.patientID;
        this.patientName = builder.patientName;
        this.billAmount = builder.billAmount;
    }

    public String getBillNo() {
        return billNo;
    }

    public String getPatientID() {
        return patientID;
    }

    public String getPatientName() {
        return patientName;
    }

    public float getBillAmount() {
        return billAmount;
    }

    @Override
    public String toString()
    {
        return "Bill{" +
                "billNo=" + billNo +
                ", patientID=" + patientID +
                ", patientName='" + patientName + '\'' +
                ", billAmount=" + billAmount +
                '}';
    }

    public static class Builder
    {
        private String billNo;
        private String patientID;
        private String patientName;
        private float billAmount;

        public Builder setBillNo(String billNo)
        {
            this.billNo = billNo;
            return this;
        }

        public Builder setPatientID(String patientID)
        {
            this.patientID = patientID;
            return this;
        }

        public Builder setPatientName(String patientName)
        {
            this.patientName = patientName;
            return this;
        }

        public Builder setBillAmount(float billAmount)
        {
            this.billAmount = billAmount;
            return this;
        }

        public Builder copy(Bill bill)
        {
            this.billNo = bill.billNo;
            this.patientID = bill.patientID;
            this.patientName = bill.patientName;
            this.billAmount = bill.billAmount;
            return this;
        }

        public Bill build()
        {
            return new Bill(this);
        }
    }
}
