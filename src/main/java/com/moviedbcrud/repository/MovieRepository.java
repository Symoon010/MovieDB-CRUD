package com.moviedbcrud.repository;

import com.moviedbcrud.model.entity.AdminEntity;
import com.moviedbcrud.model.entity.MovieEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity,Integer> {

    @Query("FROM MovieEntity WHERE category = :category")
    public List<MovieEntity>getMovieByCategory(String category);

    @Query("FROM MovieEntity WHERE language = :language")
    public List<MovieEntity>getMovieByLanguage(String language);
    Page findByName(String category, Pageable pageable);
}
