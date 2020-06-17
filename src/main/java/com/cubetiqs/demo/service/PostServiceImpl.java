package com.cubetiqs.demo.service;

import com.cubetiqs.demo.domain.PostEntity;
import com.cubetiqs.demo.repository.BaseRepository;
import com.cubetiqs.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
