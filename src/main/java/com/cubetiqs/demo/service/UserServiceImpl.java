package com.cubetiqs.demo.service;

import com.cubetiqs.demo.domain.UserEntity;
import com.cubetiqs.demo.repository.BaseRepository;
import com.cubetiqs.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserEntity, Long> implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public BaseRepository<UserEntity, Long> getRepository() {
        return userRepository;
    }

    @Override
    public Page<UserEntity> findAll(Pageable pageable, String q) {
        return null;
    }

    @Override
    public List<UserEntity> findAllActives() {
        return userRepository.findAllActives();
    }
}
