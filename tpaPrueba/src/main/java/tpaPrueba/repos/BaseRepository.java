package tpaPrueba.repos;

import io.micronaut.data.repository.CrudRepository;
import tpaPrueba.ent.Base;

import java.io.Serializable;

public interface BaseRepository<T extends Base, ID extends Serializable> extends CrudRepository<T,ID> {
}
