package eu.exposit.DeliveryService.services;

import eu.exposit.DeliveryService.api.repositories.CrudRepository;
import eu.exposit.DeliveryService.api.services.CrudService;
import eu.exposit.DeliveryService.exceptions.NoRecordException;
import eu.exposit.DeliveryService.model.BaseEntity;

import java.util.List;

public abstract class CrudServiceImpl<T extends BaseEntity> implements CrudService<T> {

    protected CrudRepository<T> crudRepository;

    @Override
    public T create(T entity) {
        return crudRepository.create(entity);
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
    public void deleteById(Long id) throws NoRecordException {
        crudRepository.deleteById(id);
    }

}
