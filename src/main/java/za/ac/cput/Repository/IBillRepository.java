package za.ac.cput.Repository;

import za.ac.cput.Entity.Bill;

import java.util.Set;

public interface IBillRepository extends IRepository<Bill,String>
{
    public Set<Bill> getAll();
}
