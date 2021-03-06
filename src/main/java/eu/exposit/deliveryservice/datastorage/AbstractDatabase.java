package eu.exposit.deliveryservice.datastorage;

import eu.exposit.deliveryservice.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class AbstractDatabase<T extends BaseEntity> {

    private List<T> entities;
    private Long idSequence;

    public T create(T entity) {
        entity.setId(idSequence++);
        entities.add(entity);
        return entity;
    }

}
