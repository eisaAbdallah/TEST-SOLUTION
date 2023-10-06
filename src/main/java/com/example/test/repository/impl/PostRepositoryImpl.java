package com.example.test.repository.impl;

import com.example.test.data.PostBodyDTO;
import com.example.test.model.Posts;
import com.example.test.model.Review;
import com.example.test.repository.PostRepository;
import com.example.test.repository.PostsPagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository {
    @Autowired
    EntityManager entityManager;
   @Autowired
    PostsPagination postsPagination;
    @Override
    @Transactional
    public void addPost(Posts postBody) {

        entityManager.merge(postBody);
    }

    @Override
    @Transactional
    public List<Posts> postsListPaged(int size,int page) {


        Pageable paging = PageRequest.of(page, size);

      Page<Posts> posts=  postsPagination.findAll(paging);
List<Posts>postsList=posts.getContent();

        return postsList;
    }

    @Override
    @Transactional
    public void addReviewToPost(Review review) {
entityManager.merge(review);
    }

    @Override
    @Transactional
    public Posts findPostById(int id) {
        TypedQuery<Posts> postsTypedQuery=entityManager.createQuery("from Posts where id=?1",Posts.class);
        postsTypedQuery.setParameter(1,id);
       Posts postsList=postsTypedQuery.getSingleResult();
        return postsList;

    }
}
