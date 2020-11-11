package tpaPrueba.serv;

import io.micronaut.core.annotation.Introspected;
import tpaPrueba.ent.Localidad;
import tpaPrueba.repos.LocalidadRepository;

import javax.inject.Singleton;

@Singleton
@Introspected
public class LocalidadServiceImpl extends BaseServiceImpl<Localidad, Long> implements LocalidadService {

    public LocalidadServiceImpl(LocalidadRepository baseRepository) {
        super(baseRepository);
    }

}