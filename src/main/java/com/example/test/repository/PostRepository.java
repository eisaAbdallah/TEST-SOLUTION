package com.example.test.repository;

import com.example.test.data.PostBodyDTO;
import com.example.test.model.Posts;

import java.util.List;

public interface PostRepository {

    void addPost(PostBodyDTO postBodyDTO);
    List<Posts> postsListPaged(int page,int size);

    void addReviewToPost(Posts review);

    Posts findPostById(int id);
}
