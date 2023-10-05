package com.example.test.service.impl;

import com.example.test.data.PostBodyDTO;
import com.example.test.model.Posts;
import com.example.test.model.Review;
import com.example.test.repository.PostRepository;
import com.example.test.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
@Autowired
    PostRepository postRepository;
    @Override
    public void addPost(PostBodyDTO postBodyDTO) {
        postRepository.addPost(postBodyDTO);
    }

    @Override
    public List<Posts> postsList(Pageable pageable) {

        List<Posts>posts =postRepository.postsListPaged(pageable.getPageNumber(),pageable.getPageSize());
        return posts;
    }

    @Override
    public void addReviewToPost(String review,int id) {

        Posts posts= postRepository.findPostById(id);
        Review reviewData=new Review();
        posts.getReviewSet().add(reviewData);
        postRepository.addReviewToPost(posts);
    }

    public List<Posts> getAllPosts(Integer pageNo, Integer pageSize)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize);

        List<Posts> pagedResult = postRepository.postsListPaged(pageNo,pageSize);

        return pagedResult;
}}
