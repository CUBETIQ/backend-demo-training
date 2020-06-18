package com.cubetiqs.demo.repository;

import com.cubetiqs.demo.Constants;
import com.cubetiqs.demo.domain.Status;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public class BaseRepositoryImpl<T, ID extends Serializable>
        extends SimpleJpaRepository<T, ID>
        implements BaseRepository<T, ID> {
    private final EntityManager entityManager;
    public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public List<T> findAllActives() {
        Specification<T> specification = (Specification<T>) (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(Constants.STATUS), Status.ACTIVE);
        return findAll(specification);
    }
}
