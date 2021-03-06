package eu.exposit.deliveryservice.services;

import eu.exposit.deliveryservice.api.repositories.CrudRepository;
import eu.exposit.deliveryservice.api.services.CrudService;
import eu.exposit.deliveryservice.exceptions.NoRecordException;
import eu.exposit.deliveryservice.exceptions.RecordAlreadyExistsException;
import eu.exposit.deliveryservice.model.BaseEntity;

import java.util.List;

public abstract class CrudServiceImpl<T extends BaseEntity> implements CrudService<T> {

    protected CrudRepository<T> crudRepository;

    @Override
    public T create(T entity) throws RecordAlreadyExistsException {
        return crudRepository.create(entity);
    }

    @Override
    public T get(T entity) throws NoRecordException {
        return crudRepository.get(entity).orElseThrow(NoRecordException::new);
    }

    @Override
    public T getById(Long id) throws NoRecordException {
        return crudRepository.getById(id).orElseThrow(NoRecordException::new);
    }

    @Override
    public List<T> getAll() {
        return crudRepository.getAll();
    }

    @Override
    public T update(T entity) {
        return crudRepository.update(entity);
    }

    @Override
    public void delete(T entity) throws NoRecordException {
        crudRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) throws NoRecordException {
        crudRepository.deleteById(id);
    }

}
