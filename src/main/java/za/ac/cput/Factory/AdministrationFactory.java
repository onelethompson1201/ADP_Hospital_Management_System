/* AdministrationFactory.java
   Factory for the administration(220110530)
   Author: Duncan Benjamin Harris
   Date: 08 April 2022 
*/
package za.ac.cput.Factory;

import za.ac.cput.Entity.Administration;
import za.ac.cput.util.Helper;

public class AdministrationFactory 
{
    public static Administration createAdministration(String adminName, String adminPassword)
    {
        String adminID = Helper.generateAdministrationID();
        Administration administration = new Administration.Builder().setAdminID(adminID).
                        setAdminName(adminName).    
                        setAdminPassword(adminPassword).
                        build();
        return administration;
    }
}

