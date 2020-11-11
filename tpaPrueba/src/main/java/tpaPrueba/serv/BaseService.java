package tpaPrueba.serv;

import tpaPrueba.ent.Base;
import java.io.Serializable;
import java.util.Optional;

public interface BaseService<E extends Base, ID extends Serializable> {

    Iterable<E> getAll();
    Optional<E> findOne(ID id);
    E save(E entity) throws Exception;
    E update(ID id, E entity) throws Exception;
    void delete(ID id);

}