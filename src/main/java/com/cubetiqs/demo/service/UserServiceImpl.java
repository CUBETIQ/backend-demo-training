package com.cubetiqs.demo.service;

import com.cubetiqs.demo.domain.UserEntity;
import com.cubetiqs.demo.domain.view.UserView;
import com.cubetiqs.demo.repository.BaseRepository;
import com.cubetiqs.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public UserEntity findByEmail(String email) throws UserNotFoundException {
        Optional<UserEntity> opt = userRepository.fetchFirstByEmail(email);
        if (opt.isPresent()) {
            return opt.get();
        }

        throw new UserNotFoundException("user does not exists");
    }

    @Override
    public Page<UserEntity> searchByEmail(String email, Pageable pageable) {
        return userRepository.searchByEmail(email, pageable);
    }

    @Override
    public Page<UserView> searchByEmailAsView(String email, Pageable pageable) {
        Page<UserEntity> users = userRepository.searchByEmail(email, pageable);
        return users.map(s -> new UserView(s.getId(), s.getEmail()));
    }
}
