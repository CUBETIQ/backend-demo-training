package com.cubetiqs.demo.service;

import com.cubetiqs.demo.domain.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserEntity> findAllUsers();
}
