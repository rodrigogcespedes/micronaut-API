package tpaPrueba.serv;

import io.micronaut.core.annotation.Introspected;
import tpaPrueba.ent.Autor;
import tpaPrueba.repos.AutorRepository;

import javax.inject.Singleton;


@Singleton
@Introspected
public class AutorServiceImpl extends BaseServiceImpl<Autor, Long> implements AutorService{

    public AutorServiceImpl(AutorRepository baseRepository) {
        super(baseRepository);
    }
}
