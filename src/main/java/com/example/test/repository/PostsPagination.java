package com.example.test.repository;

import com.example.test.model.Posts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface PostsPagination extends JpaRepository<Posts,Integer> {


}
