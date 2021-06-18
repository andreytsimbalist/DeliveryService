package eu.exposit.DeliveryService.api.repositories;

import eu.exposit.DeliveryService.exceptions.NoRecordException;
import eu.exposit.DeliveryService.model.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T extends BaseEntity> {

    T create(T entity);

    Optional<T> getById(Long id);

    List<T> getAll();

    T update(T entity);

    void deleteById(Long id) throws NoRecordException;

}
