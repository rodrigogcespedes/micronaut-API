package tpaPrueba.serv;

import io.micronaut.core.annotation.Introspected;
import tpaPrueba.ent.Persona;
import tpaPrueba.repos.PersonaRepository;

import javax.inject.Singleton;

@Singleton
@Introspected
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService{

    public PersonaServiceImpl(PersonaRepository baseRepository) {
        super(baseRepository);
    }

    public Iterable<Persona> getByNombreOrApellido(String nombre, String apellido){
        return ((PersonaRepository) baseRepository).findByNombreContainsOrApellidoContains(nombre, apellido);
    }
}
