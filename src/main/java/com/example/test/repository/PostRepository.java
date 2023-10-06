package com.example.test.repository;

import com.example.test.data.PostBodyDTO;
import com.example.test.model.Posts;
import com.example.test.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostRepository {

    void addPost(Posts posts);
    List<Posts> postsListPaged(int size, int page );

    void addReviewToPost(Review review);

    Posts findPostById(int id);
}
