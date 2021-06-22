package eu.exposit.DeliveryService.repositories;

import eu.exposit.DeliveryService.DataStorage.AbstractDatabase;
import eu.exposit.DeliveryService.api.repositories.CrudRepository;
import eu.exposit.DeliveryService.exceptions.NoRecordException;
import eu.exposit.DeliveryService.model.BaseEntity;

import java.util.List;
import java.util.Optional;

public abstract class CrudRepositoryImpl<T extends BaseEntity> implements CrudRepository<T> {

    protected AbstractDatabase<T> abstractDatabase;

    @Override
    public T create(T entity) {
        return abstractDatabase.create(entity);
    }

    @Override
    public Optional<T> get(T entity) {
        return abstractDatabase.getEntities()
                .stream()
                .filter(temp -> temp.equals(entity))
                .findFirst();
    }

    @Override
    public Optional<T> getById(Long id) {
        return abstractDatabase.getEntities()
                .stream()
                .filter(entity -> entity.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<T> getAll() {
        return abstractDatabase.getEntities();
    }

    @Override
    public T update(T entity) {
        int index = abstractDatabase.getEntities().indexOf(entity);
        return abstractDatabase.getEntities().set(index, entity);
    }

    @Override
    public void delete(T entity) throws NoRecordException {
        T entityToDelete = abstractDatabase.getEntities()
                .stream()
                .filter(temp -> temp.equals(entity))
                .findFirst()
                .orElseThrow(NoRecordException::new);
        abstractDatabase.getEntities().remove(entityToDelete);
    }

    @Override
    public void deleteById(Long id) throws NoRecordException {
        T entityToDelete = abstractDatabase.getEntities()
                .stream()
                .filter(entity -> entity.getId().equals(id))
                .findFirst()
                .orElseThrow(NoRecordException::new);
        abstractDatabase.getEntities().remove(entityToDelete);
    }

}
