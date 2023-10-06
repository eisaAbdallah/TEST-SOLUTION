package com.example.test.service.impl;

import com.example.test.data.PostBodyDTO;
import com.example.test.data.PostsResponse;
import com.example.test.model.Posts;
import com.example.test.model.Review;
import com.example.test.repository.PostRepository;
import com.example.test.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
@Autowired
    PostRepository postRepository;
    @Override
    public void addPost(PostBodyDTO postBodyDTO) {
        Posts posts=new Posts();
        posts.setBody(postBodyDTO.getStoryBody());
        posts.setTitle(postBodyDTO.getTitle());

        postRepository.addPost(posts);
    }

    @Override
    public List<PostsResponse> postsList(int size,int page) {
        PostsResponse postsResponse=null;
        List<Posts>posts =postRepository.postsListPaged(size,page);
        List<PostsResponse>postsResponses=new ArrayList<>();
        for(Posts result:posts){

postsResponse=new PostsResponse(result.getId(),result.getTitle(),result.getTitle(),result.getCreatedOn(),result.getReviewSet());
            postsResponses.add(postsResponse);
        }


        return postsResponses;
    }

    @Override
    public void addReviewToPost(String review,int id) {

        Posts posts= postRepository.findPostById(id);
        Review reviewData=new Review();
        reviewData.setComment(review);
        reviewData.setPosts(posts);

        postRepository.addReviewToPost(reviewData);
    }

   }
