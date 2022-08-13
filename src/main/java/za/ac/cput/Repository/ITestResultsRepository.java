package za.ac.cput.Repository;

/* ITestResultsRepository.java
 Interface for TestResults
 Author: Onele Tomson (219483280)
*/

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.Entity.TestResults;

public interface ITestResultsRepository extends JpaRepository<TestResults, String > {
}
