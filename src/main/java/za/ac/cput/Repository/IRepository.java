package za.ac.cput.Repository;

/**
 *
 * @author Chuma Edward Nxazonke
 * Student number: 219181187
 * Date 07 April 2022
 */

public interface IRepository<T, ID>
{
   T create(T t);
   T read(ID id);
   T update(T t);
   boolean delete(ID id);
}
