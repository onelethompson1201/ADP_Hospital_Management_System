package za.ac.cput.Service;

public interface IService <T, ID>{

    T save(T t);

    T read(ID id);

    void delete(ID id);
}
