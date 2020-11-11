package tpaPrueba.repos;

import io.micronaut.context.annotation.Primary;
import io.micronaut.data.annotation.Repository;
import tpaPrueba.ent.Autor;

@Repository
public interface AutorRepository extends BaseRepository<Autor,Long> {
}
