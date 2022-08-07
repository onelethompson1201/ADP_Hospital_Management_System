package za.ac.cput.Repository;

import za.ac.cput.Entity.Bill;

import java.util.Set;

<<<<<<< HEAD
public interface IBillRepository extends IRepository <Bill, String>
{
=======
public interface IBillRepository extends IRepository<Bill,String>
{
    Bill create(Bill bill);
    Bill read(String billNo);
>>>>>>> origin/main
    public Set<Bill> getAll();
}
