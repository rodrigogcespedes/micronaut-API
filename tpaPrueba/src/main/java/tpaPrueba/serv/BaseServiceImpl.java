package tpaPrueba.serv;

import io.micronaut.core.annotation.Introspected;
import tpaPrueba.ent.Base;
import tpaPrueba.repos.BaseRepository;

import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Optional;

@Singleton
@Introspected
public abstract class BaseServiceImpl<E extends Base, ID extends Serializable> implements BaseService<E, ID> {

    protected BaseRepository<E, ID> baseRepository;

    public BaseServiceImpl(BaseRepository<E, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public Iterable<E> getAll() {
        return baseRepository.findAll();
    }

    @Override
    public Optional<E> findOne(ID id) {
        return baseRepository.findById(id);
    }

    @Override
    @Transactional
    public E save(E entity) throws Exception {
        try {
            entity = baseRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E update(ID id, E entity) throws Exception {

        E saved = null;

        if (entity.getId() != null && baseRepository.existsById((ID)entity.getId())) {
            saved = baseRepository.update(entity);
        } else {
            saved = baseRepository.save(entity);
        }

        return saved;
    }

    @Override
    public void delete(ID id) {
        baseRepository.deleteById(id);

    }
}