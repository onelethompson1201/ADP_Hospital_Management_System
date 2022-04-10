/* AdministrationRepository.java
   Repository for the administration
   Author: Duncan Benjamin Harris
   Date: 08 April 2022 
*/
package za.ac.cput.Repository;

import java.util.HashSet;
import java.util.Set;
import za.ac.cput.Entity.Administration;

public class AdministrationRepository implements IAdministrationRepository
{
    private static AdministrationRepository repository = null;
    private Set<Administration> administrationDB = null;
    
    private AdministrationRepository()
    {
        administrationDB = new HashSet<Administration>();
    }
    
    public static AdministrationRepository getRepository()
    {
        if (repository == null)
        {
            repository = new AdministrationRepository();
        }
        return repository;
    }
    
    @Override
    public Administration create(Administration administration)
    {
        boolean success = administrationDB.add(administration);
        if(!success)
        {
            return null;
        }    
        return administration;
    }
    
    
    @Override
    public Administration read(String adminID)
    {
        Administration administration = administrationDB.stream()
                .filter(e -> e.getAdminID().equals(adminID))
                .findAny()
                .orElse(null);
        return administration;
                
    }
    
    @Override
    public Administration update(Administration administration)
    {
        Administration oldAdministration = read(administration.getAdminID());
        if(oldAdministration != null)
        {
            administrationDB.remove(oldAdministration);
            administrationDB.add(administration);
            return administration;
        }
        return null;
    }
    
    @Override
    public boolean delete(String adminID)
    {
        Administration adminToDelete = read(adminID);
        if(adminToDelete == null)
        {
            return false;
        }
        administrationDB.remove(adminToDelete);
        return true;
    }
    
    @Override
    public Set<Administration> getAll()
    {
        return administrationDB;
    }
}

