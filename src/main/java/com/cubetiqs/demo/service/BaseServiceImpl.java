package com.cubetiqs.demo.service;

import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public abstract class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {
    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }
}
