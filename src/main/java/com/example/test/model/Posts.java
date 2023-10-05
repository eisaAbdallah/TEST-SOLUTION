package com.example.test.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
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
    @OneToMany(mappedBy="posts")
    private Set<Review> reviewSet;
     @CreationTimestamp
    private LocalDateTime createdOn;

    public Posts(int id, String title, String body, LocalDateTime createdOn) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.createdOn = createdOn;
    }
}
