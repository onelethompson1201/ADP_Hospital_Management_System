package za.ac.cput.Repository;

import java.util.*;

import za.ac.cput.Entity.Administration;
import za.ac.cput.Entity.Appointment;
import za.ac.cput.Entity.Laboratory;

/***
 * @author: Chuma Nxazonke
 * Student number: 219181187
 * Date: 08 April 2022
 */

public class LaboratoryRepository implements ILaboratory {
    private static LaboratoryRepository labRepository = null;
    private  Set<Laboratory> laboratoryDB = null;

    private LaboratoryRepository(){
        laboratoryDB = new HashSet<Laboratory>();
    }

    public static LaboratoryRepository getRepository() {
        if (labRepository == null)
        {
            labRepository = new LaboratoryRepository();
        }
        return labRepository;
    }


    public Laboratory create(Laboratory laboratory) {
        this.laboratoryDB.add(laboratory);
        return laboratory;


    }

    @Override
    public Laboratory read( String labID) {
        Laboratory laboratory = laboratoryDB.stream().filter(e -> e.getLabID().equals(labID))
                .findAny().orElse(null);
        return laboratory;

    }


    public Laboratory update(Laboratory laboratory) {
        Laboratory olderLabCard = read(laboratory.getLabID());
        if (olderLabCard != null) {
            laboratoryDB.remove(olderLabCard);
            laboratoryDB.add(laboratory);
            return laboratory;
        }
        return null;
    }

    @Override


    public boolean  delete(String labID) {
        Laboratory delete  = read(labID);
        if (delete == null) {
            System.out.println("Laboratory card is null.");
            return false;
        }
        laboratoryDB.remove(delete);
        System.out.println("Laboratory card removed successfully.");
        return true;
    }

    @Override
    public Set<Laboratory> getAll() {
        return laboratoryDB;
    }

}

