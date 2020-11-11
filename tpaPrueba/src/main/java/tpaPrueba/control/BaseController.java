package tpaPrueba.control;

import java.io.Serializable;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.PathVariable;
import tpaPrueba.ent.Base;

public interface BaseController<E extends Base, ID extends Serializable> {

    HttpResponse<?> findAll();
    HttpResponse<?> findOne(@PathVariable ID id);
    HttpResponse<?> save(@Body E entity);
    HttpResponse<?> update(@PathVariable ID id, @Body E entity);
    HttpResponse<?> delete(@PathVariable ID id);
}