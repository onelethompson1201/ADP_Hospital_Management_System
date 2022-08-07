/* MediclRecordsRepository.java
   Repository for the MedicalRecords(220110530)
   Author: Duncan Benjamin Harris
   Date: 08 April 2022 
*/
package za.ac.cput.Repository;

import java.util.HashSet;
import java.util.Set;
import za.ac.cput.Entity.MedicalRecords;

public class MedicalRecordsRepository implements IMedicalRecordsRepository
{
    private static MedicalRecordsRepository repository = null;
    private Set<MedicalRecords> medicalRecordsDB = null;
    
    private MedicalRecordsRepository()
    {
        medicalRecordsDB = new HashSet<MedicalRecords>();
    }
    
    public static MedicalRecordsRepository getRepository()
    {
        if (repository == null)
        {
            repository = new MedicalRecordsRepository();
        }
        return repository;
    }
    
    @Override
    public MedicalRecords create(MedicalRecords medicalRecords)
    {
        boolean success = medicalRecordsDB.add(medicalRecords);
        if(!success)
        {
            return null;
        }    
        return medicalRecords;
    }
    
    
    @Override
    public MedicalRecords read(String recordID)
    {
        MedicalRecords medicalRecords = medicalRecordsDB.stream()
                .filter(e -> e.getRecordID().equals(recordID))
                .findAny()
                .orElse(null);
        return medicalRecords;
                
    }
    
    @Override
    public MedicalRecords update(MedicalRecords medicalRecords)
    {
        MedicalRecords oldMedicalRecords = read(medicalRecords.getRecordID());
        if(oldMedicalRecords != null)
        {
            medicalRecordsDB.remove(oldMedicalRecords);
            medicalRecordsDB.add(medicalRecords);
            return medicalRecords;
        }
        return null;
    }
    
    @Override
    public boolean delete(String recordID)
    {
        MedicalRecords recordToDelete = read(recordID);
        if(recordToDelete == null)
        {
            return false;
        }
        medicalRecordsDB.remove(recordToDelete);
        return true;
    }
    
    @Override
    public Set<MedicalRecords> getAll()
    {
        return medicalRecordsDB;
    }
}

