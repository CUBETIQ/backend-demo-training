package com.cubetiqs.demo.repository;

import com.cubetiqs.demo.domain.PostEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends BaseRepository<PostEntity, Long> {
    
}
