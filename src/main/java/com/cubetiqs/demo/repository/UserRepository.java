package com.cubetiqs.demo.repository;

import com.cubetiqs.demo.domain.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<UserEntity, Long> {
        
}
