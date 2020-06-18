package com.cubetiqs.demo.rest;

import com.cubetiqs.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/posts"})
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllPosts(
            Pageable pageable,
            @RequestParam(value = "view", defaultValue = "list") String viewType,
            @RequestParam(value = "q", defaultValue = "") String q
    ) {
        if ("list".equalsIgnoreCase(viewType)) {
            return ResponseEntity.ok(postService.findAllActives());
        }
        return ResponseEntity.ok(postService.findAll(pageable));
    }
}
