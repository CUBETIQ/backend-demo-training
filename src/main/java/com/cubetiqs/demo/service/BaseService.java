package com.cubetiqs.demo.service;

import com.cubetiqs.demo.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface BaseService<T, ID extends Serializable> {
    BaseRepository<T, ID> getRepository();
    Page<T> findAll(Pageable pageable, String q);
    Page<T> findAll(Pageable pageable);
    List<T> findAll();
    List<T> findAllActives();
}
