package tpaPrueba.control;

import io.micronaut.http.annotation.Controller;
import tpaPrueba.ent.Localidad;
import tpaPrueba.serv.LocalidadServiceImpl;

@Controller("api/v1/localidades")
public class LocalidadController extends BaseControllerImpl<Localidad, LocalidadServiceImpl>{

    public LocalidadController(LocalidadServiceImpl localidadService) {
        super(localidadService);
    }

}
/*
CREATE
{
    "denominacion": "nombre_localidad",
}
 */