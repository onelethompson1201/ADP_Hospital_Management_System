package za.ac.cput.Factory;
/* BillFactory.java
   Factory Class: BillFactory(220021333)
   Author: Davin Shaun Carstens
*/
import za.ac.cput.Entity.Bill;
import za.ac.cput.util.Helper;

public class BillFactory
{
    public static Bill createBill(String id, String patientID,
                                  String patientName,
                                  float billAmount)
    {
        String billNo = Helper.generateBillID();
        Bill bill = new Bill.Builder()
                .setBillNo(billNo)
                .setPatientID(patientID)
                .setPatientName(patientName)
                .setBillAmount(billAmount)
                .build();
        return bill;
    }
}
