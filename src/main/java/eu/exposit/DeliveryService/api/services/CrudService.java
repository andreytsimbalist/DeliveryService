package eu.exposit.DeliveryService.api.services;

import eu.exposit.DeliveryService.exceptions.NoRecordException;
import eu.exposit.DeliveryService.model.BaseEntity;

import java.util.List;

public interface CrudService<T extends BaseEntity> {

    T create(T entity);

    T getById(Long id) throws NoRecordException;

    List<T> getAll();

    T update(T entity);

    void deleteById(Long id) throws NoRecordException;

}
