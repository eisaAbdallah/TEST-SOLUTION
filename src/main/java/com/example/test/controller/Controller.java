package com.example.test.controller;

import com.example.test.data.PostBodyDTO;
import com.example.test.model.Posts;
import com.example.test.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
@Autowired
PostService postService;
    @PostMapping("add/post")
    public ResponseEntity<?> addPost(@RequestBody PostBodyDTO postBodyDTO){

        postService.addPost(postBodyDTO);

return ResponseEntity.ok("Post Successfully created");
    }
    @GetMapping("post/list")
    public ResponseEntity<?> getPosts(@RequestParam(value = "size",required = false)int size,@RequestParam(value = "page",required = false)int page){
        Pageable paging = PageRequest.of(page, size);
        List<Posts> postsList=postService.postsList(paging);


        return ResponseEntity.ok("Posts Of the User"+postsList);
    }

    @PostMapping("add/review/post/{id}")
    public ResponseEntity<?> addReviewToPost(@RequestBody PostBodyDTO postBodyDTO,@PathVariable("id")int id){

        postService.addReviewToPost(postBodyDTO.getReview(),id);

        return ResponseEntity.ok("Comment Successfully added");
    }
}
