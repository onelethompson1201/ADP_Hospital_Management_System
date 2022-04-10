package za.ac.cput.Repository;

import za.ac.cput.Entity.Laboratory;

import java.util.Set;

/**
 * @author Chuma Nxazonke
 * Student number: 219181187
 * Date: 08 April 2022
 *
 */

public interface ILaboratory extends IRepository <Laboratory, String> {

    //  CRUD operation performed
    public Set<Laboratory> getAll();

}

