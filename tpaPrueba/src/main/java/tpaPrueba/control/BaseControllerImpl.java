package tpaPrueba.control;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import tpaPrueba.ent.Base;
import tpaPrueba.serv.BaseServiceImpl;

@ExecuteOn(TaskExecutors.IO)
public abstract class BaseControllerImpl<E extends Base, S extends BaseServiceImpl<E, Long>> implements BaseController<E, Long> {

    protected S servicio;

    public BaseControllerImpl(S s) {
        this.servicio = s;
    }

    @Override
    @Get
    public HttpResponse<?> findAll() {
        try {
            return HttpResponse.status(HttpStatus.OK).body(servicio.getAll());
        } catch (Exception ex) {
            return HttpResponse.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
        }
    }

    @Override
    @Get("/{id}")
    public HttpResponse<?> findOne(@PathVariable Long id) {
        try {
            return HttpResponse.status(HttpStatus.OK).body(servicio.findOne(id));
        } catch (Exception ex) {
            return HttpResponse.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
        }
    }

    @Override
    @Post("/save")
    public HttpResponse<?> save(@Body E entity) {
        try {
            return HttpResponse.status(HttpStatus.OK).body(
                    servicio.save(entity)
            );
        } catch (Exception e) {
            return HttpResponse.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
        }
    }

    @Override
    @Put("/{id}")
    public HttpResponse<?> update(@PathVariable Long id, @Body E entity) {
        try {
            return HttpResponse.status(HttpStatus.OK).body(servicio.update(entity.getId(), entity));
        } catch (Exception e) {
            return HttpResponse.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde1.\"}");
        }
    }

    @Delete("delete/{id}")
    public HttpResponse<?> delete(@PathVariable Long id) {
        try {
            servicio.delete(id);
            return HttpResponse.status(HttpStatus.OK);
        } catch (Exception ex) {
            return HttpResponse.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
        }
    }
}

