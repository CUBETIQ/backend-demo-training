package com.cubetiqs.demo.repository;

import com.cubetiqs.demo.domain.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<UserEntity, Long> {
    Optional<UserEntity> findFirstByEmail(String email);

    @Query(value = "select * from users u where u.email = ?1", nativeQuery = true)
    Optional<UserEntity> fetchFirstByEmail(String email);

    @Query(value = "select * from users u", nativeQuery = true)
    Page<UserEntity> fetchAllUsers(Pageable pageable);

    @Query(value = "select * from users u where lower(u.email) like ?1", nativeQuery = true)
    Page<UserEntity> searchByEmail(String likeEmail, Pageable pageable);
}
