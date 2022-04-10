/* ReceptionistFactory.java
   Factory for the Bill
   Author: Davin Shaun Carstens
   Date: 08 April 2022
*/

package za.ac.cput.Factory;

import za.ac.cput.Entity.Receptionist;
import za.ac.cput.util.Helper;

public class ReceptionistFactory
{
    public static Receptionist createReceptionist(String receptionistName,
                                                  String receptionistPassword,
                                                  long receptionistTelephoneNumber)
    {
        String receptionistID = Helper.generateReceptionisID();
        Receptionist reception = new Receptionist.Builder()
                .setReceptionistName(receptionistName)
                .setReceptionistPassword(receptionistPassword)
                .setReceptionistTelephoneNumber(receptionistTelephoneNumber)
                .build();
        return reception;
    }
}
