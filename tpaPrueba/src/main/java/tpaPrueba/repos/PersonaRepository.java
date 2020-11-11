package tpaPrueba.repos;

import io.micronaut.context.annotation.Executable;
import io.micronaut.data.annotation.Repository;
import tpaPrueba.ent.Persona;

@Repository
public interface PersonaRepository extends BaseRepository<Persona,Long> {
    @Executable
    Iterable<Persona> findByNombreContainsOrApellidoContains(String nombre, String apellido);
}
