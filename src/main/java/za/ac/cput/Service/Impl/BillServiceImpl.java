package za.ac.cput.Service.Impl;
/* BillServiceImpl.java
   Service class: BillServiceImpl(220021333)
   Author: Davin Shaun Carstens
*/

import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Bill;
import za.ac.cput.Repository.IBillRepository;
import za.ac.cput.Service.Interfaces.BillService;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BillServiceImpl implements BillService {

    private IBillRepository repository;

    @Override
    public Bill save(Bill bill) {
        return this.repository.save(bill);
    }

    @Override
    public Bill read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(String id) {
        if(this.repository.existsById(id)){
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Set<Bill> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
