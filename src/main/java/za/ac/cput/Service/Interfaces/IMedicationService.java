package za.ac.cput.Service.Interfaces;
/**IMedicationService
 * Interface for MedicationService
 * Author: Onele Tomson(219483280)
 */

import za.ac.cput.Entity.Medication;
import za.ac.cput.Service.IService;

import java.util.List;

public interface IMedicationService extends IService<Medication, String> {
        List<Medication> getMedication();

        }
