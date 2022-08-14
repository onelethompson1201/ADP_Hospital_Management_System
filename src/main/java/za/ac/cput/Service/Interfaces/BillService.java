package za.ac.cput.Service.Interfaces;
/* BillService.java
   Interface class: BillService(220021333)
   Author: Davin Shaun Carstens
*/
import za.ac.cput.Entity.Bill;
import za.ac.cput.Service.IService;
import java.util.Set;

public interface BillService extends IService<Bill, String> {
    public Set<Bill> getAll();
}
