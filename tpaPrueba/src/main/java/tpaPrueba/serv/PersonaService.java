package tpaPrueba.serv;

import tpaPrueba.ent.Persona;

public interface PersonaService extends BaseService<Persona,Long>{
    Iterable<Persona> getByNombreOrApellido(String nombre, String apellido);
}
