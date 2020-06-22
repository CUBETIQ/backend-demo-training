package com.cubetiqs.demo.rest;

import com.cubetiqs.demo.domain.UserEntity;
import com.cubetiqs.demo.domain.view.UserView;
import com.cubetiqs.demo.repository.UserRepository;
import com.cubetiqs.demo.service.UserNotFoundException;
import com.cubetiqs.demo.service.UserService;
import com.cubetiqs.demo.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = {"/users"})
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping
    public List<UserEntity> getAllUsers(Pageable pageable) {
        return userService.findAllActives();
    }

    @GetMapping("/searchByEmail")
    public Page<UserView> searchByEmail(
            Pageable pageable,
            @RequestParam(value = "q", defaultValue = "") String q
    ) {
        return userService.searchByEmailAsView(StringUtils.stringQuery(q), pageable);
    }

    @GetMapping("/allUsers")
    public Page<UserEntity> fetchAllUsers(Pageable pageable) {
        return userRepository.fetchAllUsers(Pageable.unpaged());
    }

    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<Object> getUserById(
            @PathVariable String email
    ) {
        try {
            return ResponseEntity.ok(userService.findByEmail(email));
        } catch (UserNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
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
