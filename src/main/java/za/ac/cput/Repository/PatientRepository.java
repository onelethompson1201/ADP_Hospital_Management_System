package za.ac.cput.Repository;

import za.ac.cput.Entity.Patient;
import za.ac.cput.Factory.PatientFactory;

import java.util.HashSet;
import java.util.Set;

public class PatientRepository implements IPatientRepository{
    private Set<Patient> PatientDB;;
    private static PatientRepository repository = null;
    private PatientRepository(){
        PatientDB = new HashSet<Patient>();
    }

    public static PatientRepository getRepository(){
        if(repository==null){
            repository = new PatientRepository();
        }
        return repository;
    }
    @Override
    public Patient create(Patient patient){
        boolean success = PatientDB.add(patient);
        if(!success)
            return null;
        return patient;
    }

    @Override
    public Patient read(String patientID){
        Patient patient = PatientDB.stream().filter(e -> e.getPatientID().equals(patientID))
                .findAny().orElse(null);
        return patient;
    }

    @Override
    public Patient update(Patient patient){
        Patient oldPatient = read(patient.getPatientID());
        if(oldPatient != null)
        {
            System.out.println("removed" +oldPatient);
            PatientDB.remove(oldPatient);
            PatientDB.add(patient);
        }
        return patient;
    }

    @Override
    public boolean delete(String patientID){
        Patient deletePatient = read(patientID);
        if(deletePatient == null)
        {
            return false;
        }
        PatientDB.remove(deletePatient);
        System.out.println("Deleted!");
        return true;
    }

    @Override
    public Set<Patient>getAll(){
        return PatientDB;
    }

    public static void main(String[] args) {
        Patient pat = PatientFactory.createPatient("Nolubabalo", "67 Ngcwalazi Drive",
                438762089, "Female", 23, "hello");
        Patient pat1 = PatientFactory.createPatient("Nolu", "90 Live Street",
                89654787, "Male", 16, "liveOnce");


    }

}
