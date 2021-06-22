package eu.exposit.deliveryservice.api.services;

import eu.exposit.deliveryservice.exceptions.NoRecordException;
import eu.exposit.deliveryservice.exceptions.RecordAlreadyExistsException;
import eu.exposit.deliveryservice.model.BaseEntity;

import java.util.List;

public interface CrudService<T extends BaseEntity> {

    T create(T entity) throws RecordAlreadyExistsException;

    T get(T entity) throws NoRecordException;

    T getById(Long id) throws NoRecordException;

    List<T> getAll();

    T update(T entity);

    void delete(T entity) throws NoRecordException;

    void deleteById(Long id) throws NoRecordException;

}
