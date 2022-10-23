package com.moviedbcrud.repository;

import com.moviedbcrud.model.entity.MovieEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MoviePaginationRepository extends PagingAndSortingRepository<MovieEntity,Integer> {

}
