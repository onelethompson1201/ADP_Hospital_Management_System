/* ITestResultsRepository.java
 Entity for the ITestResultsRepository
 Author: Onele Tomson (219483280)
 Date: 08 May 2022
*/

package za.ac.cput.Repository;
import java.util.Set;
import za.ac.cput.Entity.TestResults;



public interface TestResultsRepository extends IRepository
{
    public Set<TestResults> getAll();
}