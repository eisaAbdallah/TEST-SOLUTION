package com.example.test.service;

import com.example.test.data.PostBodyDTO;
import com.example.test.model.Posts;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
     void addPost(PostBodyDTO postBodyDTO);
     List<Posts> postsList(Pageable pageable);

    void addReviewToPost(String review,int id);
}
