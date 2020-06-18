package com.cubetiqs.demo.service;

import com.cubetiqs.demo.domain.PostEntity;
import com.cubetiqs.demo.repository.BaseRepository;
import com.cubetiqs.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl extends BaseServiceImpl<PostEntity, Long> implements PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public BaseRepository<PostEntity, Long> getRepository() {
        return postRepository;
    }

    @Override
    public Page<PostEntity> findAll(Pageable pageable, String q) {
        return null;
    }

    @Override
    public List<PostEntity> findAllActives() {
        return postRepository.findAllActives();
    }
}
