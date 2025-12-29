package com.blogapp.backend.controller;

import com.blogapp.backend.model.Post;
import com.blogapp.backend.repository.PostRepository;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin("*")
public class PostController {

    private final PostRepository repo;

    public PostController(PostRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Post> all() {
        return repo.findAll(
            Sort.by(Sort.Direction.DESC,"createdAt")
        );
    }

    @PostMapping
    public Post create(@RequestBody Post post) {
        return repo.save(post);
    }
}
