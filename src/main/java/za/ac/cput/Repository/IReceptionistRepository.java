package za.ac.cput.Repository;

import za.ac.cput.Entity.Bill;
import za.ac.cput.Entity.Receptionist;

import java.util.Set;

public interface IReceptionistRepository extends IRepository <Receptionist, String>
{
    public Set<Receptionist> getAll();
}
