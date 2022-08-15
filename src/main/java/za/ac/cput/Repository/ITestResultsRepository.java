package za.ac.cput.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.Entity.TestResults;

public interface ITestResultsRepository extends JpaRepository<TestResults, String > {
}
