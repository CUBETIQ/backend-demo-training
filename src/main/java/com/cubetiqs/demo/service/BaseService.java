package com.cubetiqs.demo.service;

import com.cubetiqs.demo.repository.BaseRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface BaseService<T, ID extends Serializable> {
    BaseRepository<T, ID> getRepository();
    List<T> findAll();
}
