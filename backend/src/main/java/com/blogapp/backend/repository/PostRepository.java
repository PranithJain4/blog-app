package com.blogapp.backend.repository;

import com.blogapp.backend.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByCategoryId(Integer categoryId);
    List<Post> findByUsername(String username);
}
