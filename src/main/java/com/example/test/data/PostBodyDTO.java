package com.example.test.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostBodyDTO {
    String title;
    String storyBody;
    String review;

    public PostBodyDTO(String title, String storyBody) {
        this.title = title;
        this.storyBody = storyBody;
    }
}
