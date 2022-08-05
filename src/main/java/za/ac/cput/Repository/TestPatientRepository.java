package za.ac.cput.Repository;

import za.ac.cput.Entity.TestPatient;


import java.util.HashSet;
import java.util.Set;

public class TestPatientRepository implements ITestPatientRepository{
    private Set<TestPatient> TestPatientDB;
    private static TestPatientRepository repository = null;

    private TestPatientRepository(){
        TestPatientDB = new HashSet<TestPatient>();

    }

    public static TestPatientRepository getRepository(){
        if(repository==null){
            repository = new TestPatientRepository();
        }
        return repository;
    }


    @Override
    public TestPatient create(TestPatient test){
        boolean success = TestPatientDB.add(test);
        if(!success)
            return null;
        return test;
    }


    @Override
    public TestPatient read(String testID){
        TestPatient testPatient = TestPatientDB.stream().filter(e ->e.getTestID().equals(testID)).findAny().orElse(null);
        return testPatient;
    }

    @Override
    public TestPatient update(TestPatient test){
        TestPatient oldTest = read(test.getTestID());
        if(oldTest != null){
            System.out.println("removed" +oldTest);
            TestPatientDB.remove(oldTest);
            TestPatientDB.add(test);
        }
        return test;
    }

    @Override
    public boolean delete(String testID){
        TestPatient deleteTest = read(testID);
        if(deleteTest == null){
            return false;
        }
        TestPatientDB.remove(deleteTest);
        System.out.println("Deleted!");
        return true;
    }
    @Override
    public Set<TestPatient>getAll(){
        return TestPatientDB;
    }
}
