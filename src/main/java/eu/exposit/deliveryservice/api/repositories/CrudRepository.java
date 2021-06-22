package eu.exposit.deliveryservice.api.repositories;

import eu.exposit.deliveryservice.exceptions.NoRecordException;
import eu.exposit.deliveryservice.model.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T extends BaseEntity> {

    T create(T entity);

    Optional<T> get(T entity);

    Optional<T> getById(Long id);

    List<T> getAll();

    T update(T entity);

    void delete(T entity) throws NoRecordException;

    void deleteById(Long id) throws NoRecordException;

}
