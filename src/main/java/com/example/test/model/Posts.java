package com.example.test.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Table(name="posts")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;
    @Column(name="title")
    String  title;
    @Column(name="body")
    String body;
    @OneToMany(mappedBy="posts",fetch = FetchType.LAZY)
    private List<Review> reviewSet;
     @CreationTimestamp
     @Column(name="created_on")
    private LocalDateTime createdOn;


}
