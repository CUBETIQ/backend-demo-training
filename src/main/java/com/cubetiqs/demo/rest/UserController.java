package com.cubetiqs.demo.rest;

import com.cubetiqs.demo.domain.UserEntity;
import com.cubetiqs.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = {"/users"})
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public Page<UserEntity> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @PostMapping
    public UserEntity createUser(
            @RequestBody UserEntity user
    ) {
        return userRepository.save(user);
    }
}
