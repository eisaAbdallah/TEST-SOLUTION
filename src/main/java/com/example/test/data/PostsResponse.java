package com.example.test.data;

import com.example.test.model.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter@Setter@NoArgsConstructor
public class PostsResponse {


    int id;
    String title;
    String body;
    LocalDateTime createdOn;

    List<Review> review=new ArrayList<>();

    public PostsResponse(int id, String title, String body, LocalDateTime createdOn, List<Review> review) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.createdOn = createdOn;
        this.review = review;
    }
}
