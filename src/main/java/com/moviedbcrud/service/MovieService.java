package com.moviedbcrud.service;

import com.moviedbcrud.model.dto.Admin;
import com.moviedbcrud.model.dto.Movie;
import com.moviedbcrud.model.entity.AdminEntity;
import com.moviedbcrud.model.entity.MovieEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
    Long getMovieCount();

    Page<MovieEntity> findPaginated(int pageNo, int pageSize);

    void saveMovieIntoDb(MovieEntity movieEntity);

    void movieUpdateToDb(MovieEntity movie);

    void deleteFromDb(int id);

        MovieEntity getByID(int id);

    void saveAdminData(Admin admin);

    boolean checkAuthentication(Admin admin);

    Page findPages(Pageable pageable);

    Long getCategoryMovieCount(String category);

    Page findActionMoviePages(Pageable pageable);


    Long getLanguageMovieCount(String language);

    List<Movie> getComedyMovies();

    List<Movie> getEnglishMovies();
}
