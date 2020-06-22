package com.cubetiqs.demo.service;

import com.cubetiqs.demo.domain.UserEntity;
import com.cubetiqs.demo.domain.view.UserView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends BaseService<UserEntity, Long> {
    UserEntity findByEmail(String email) throws UserNotFoundException;
    Page<UserEntity> searchByEmail(String email, Pageable pageable);
    Page<UserView> searchByEmailAsView(String email, Pageable pageable);
}
