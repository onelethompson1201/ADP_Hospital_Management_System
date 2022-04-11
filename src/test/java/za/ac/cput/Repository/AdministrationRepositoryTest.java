/* AdministrationRepositoryTest.java
   Repository Test for the administration(220110530)
   Author: Duncan Benjamin Harris
   Date: 08 April 2022 
*/
package za.ac.cput.Repository;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Entity.Administration;
import za.ac.cput.Factory.AdministrationFactory;


@TestMethodOrder(MethodOrderer.Alphanumeric.class) //jUnit5 @TestMethodOrder(MethodOrderer.MethodName.class)
class AdministrationRepositoryTest 
{
   private static AdministrationRepository repository = AdministrationRepository.getRepository();
   private static Administration administration = AdministrationFactory.createAdministration(
           "Duncan", "Password");
   
   @Test
   void a_create()
   {
       Administration created = repository.create(administration);
       assertEquals(administration.getAdminID(), created.getAdminID());
       System.out.println("Create: " +created);
   }
   
   @Test
   void b_read()
   {
       Administration read = repository.read(administration.getAdminID());
       assertNotNull(read);
       System.out.println("Read: "+read);
   }
   
   @Test 
   void c_update()
   {
       Administration updated = new Administration.Builder().copy(administration).setAdminName("James")
               .setAdminPassword("Password2")
               .build();
       assertNotNull(repository.update(updated));
       System.out.println("Updated: "+updated);
   }
   
   @Test
   void e_delete()
   {
       boolean success = repository.delete(administration.getAdminID());
       assertTrue(success);
       System.out.println("Deleted: "+success);
   }
   
   @Test
   void d_getAll()
   {
       System.out.println("Show all:");
       System.out.println(repository.getAll());
   }
}
