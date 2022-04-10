/* BillFactory.java
   Factory for the Bill
   Author: Davin Shaun Carstens
   Date: 08 April 2022
*/

package za.ac.cput.Factory;

import za.ac.cput.Entity.Bill;
import za.ac.cput.util.Helper;

public class BillFactory
{
    public static Bill createBill(String patientID,
                                  String patientName,
                                  float billAmount)
    {
        String billNo = Helper.generateBillID();
        Bill bill = new Bill.Builder()
                .setPatientID(patientID)
                .setPatientName(patientName)
                .setBillAmount(billAmount)
                .build();
        return bill;
    }

}
