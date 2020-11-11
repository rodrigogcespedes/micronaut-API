package tpaPrueba.control;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import tpaPrueba.ent.Persona;
import tpaPrueba.serv.PersonaServiceImpl;

@Controller("api/v1/personas")
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl>{
    public PersonaController(PersonaServiceImpl personaService) {
        super(personaService);
    }

    @Get("/search")
    public HttpResponse<?> findPersonaByNombreOrApellido(@QueryValue String filtro){
        try{
            return HttpResponse.status(HttpStatus.OK).body(servicio.getByNombreOrApellido(filtro,filtro));
        }catch (Exception ex){
            return HttpResponse.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
        }
    }
}
/*
CREATE
{
    "nombre": "nombre1",
    "apellido": "apellido1",
    "dni": 42082112,
    "libros": [
        {
            "titulo": "librito",
            "genero":"drama",
            "paginas": 200,
            "fecha": 12,
            "autores":[
                {
                    "id": 4,
                    "nombre": "nombre_del_autor",
                    "apellido": "apellido_del_autor",
                    "biografia": "biografia_del_autor"
                }
            ]
        }
    ],
    "domicilio":{
        "calle": "calle_de_la_persona",
        "localidad":{
            "id": 8,
            "denominacion": "nombre_localidad"
        },
        "numero": 4
    }
}
 */