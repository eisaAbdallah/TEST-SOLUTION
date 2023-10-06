package com.example.test.service;

import com.example.test.data.PostBodyDTO;
import com.example.test.data.PostsResponse;
import com.example.test.model.Posts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
     void addPost(PostBodyDTO postBodyDTO);
     List<PostsResponse> postsList(int size, int page);

    void addReviewToPost(String review,int id);
}
