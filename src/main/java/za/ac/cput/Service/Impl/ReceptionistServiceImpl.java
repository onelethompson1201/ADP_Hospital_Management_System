package za.ac.cput.Service.Impl;
/* ReceptionistServiceImpl.java
   Service class: ReceptionistServiceImpl(220021333)
   Author: Davin Shaun Carstens
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Receptionist;
import za.ac.cput.Repository.IReceptionistRepository;
import za.ac.cput.Service.Interfaces.ReceptionistService;

@Service
public class ReceptionistServiceImpl implements ReceptionistService {

    private final IReceptionistRepository repository;

    @Autowired
    ReceptionistServiceImpl(IReceptionistRepository repository){
        this.repository = repository;
    }

    @Override
    public Receptionist save(Receptionist receptionist) {
        return this.repository.save(receptionist);
    }

    @Override
    public Receptionist read(String id) {
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
}
