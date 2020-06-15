package com.cubetiqs.demo.rest;

import com.cubetiqs.demo.domain.UserEntity;
import com.cubetiqs.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/{id}")
    public UserEntity getUserById(
            @PathVariable Long id
    ) {
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping
    public UserEntity createUser(
            @RequestBody UserEntity user
    ) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public UserEntity updateUser(
            @PathVariable Long id,
            @RequestBody UserEntity user
    ) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        if(userEntityOptional.isPresent()) {
            // found
            user.setId(id);
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(
            @PathVariable Long id
    ) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        if (userEntityOptional.isPresent()) {
            userRepository.delete(userEntityOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body("user deleted");
        } else {
            return ResponseEntity.badRequest().body("not found");
        }
    }
}
