/*
    Author: Duncan Benjamin Harris
    Student Number: 220110530
    14/08/2022
*/
package za.ac.cput.Service.Interfaces;

import za.ac.cput.Entity.Administration;
import za.ac.cput.Service.IService;

import java.util.Set;

public interface IAdministrationService extends IService<Administration, String>
{
    Set<Administration> getAll();
}
