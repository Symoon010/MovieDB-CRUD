package com.moviedbcrud.service;

import com.moviedbcrud.model.dto.Admin;
import com.moviedbcrud.model.dto.Movie;
import com.moviedbcrud.model.entity.AdminEntity;
import com.moviedbcrud.model.entity.MovieEntity;
import com.moviedbcrud.repository.AdminRepository;
import com.moviedbcrud.repository.MoviePaginationRepository;
import com.moviedbcrud.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImplementation implements MovieService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public  boolean checkAuthentication(Admin admin){
        AdminEntity adminEntity = new AdminEntity();
        String email = "";
        try {
            adminEntity = adminRepository.getUserByName(admin.getAdmin_email());
            System.out.println(adminEntity);
             if(adminEntity.getAdmin_email().equals(admin.getAdmin_email()) && adminEntity.getAdmin_password().equals(admin.getAdmin_password())){
                 return true;
             }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public List<Movie> getAllMovies() {
        List<MovieEntity> movieListEntity = new ArrayList<>();
        List<Movie> movieListDto = new ArrayList<>();
        try {
            movieListEntity = movieRepository.findAll();
            for (MovieEntity movieEntity : movieListEntity) {
                movieListDto.add(movieListEntityToDto(movieEntity));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movieListDto;
    }
    @Override
    public List<Movie> getComedyMovies(){
        List<Movie>movies = new ArrayList<>();
        try{
           List<MovieEntity>movieEntities = movieRepository.getMovieByCategory("Comedy");
           for(MovieEntity movieEntity:movieEntities){
               movies.add(movieListEntityToDto(movieEntity));
           }
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        return movies;
    }
    @Override
    public List<Movie> getEnglishMovies(){
        List<Movie>movies = new ArrayList<>();
        try{
            List<MovieEntity>movieEntities = movieRepository.getMovieByLanguage("English");
            for(MovieEntity movieEntity:movieEntities){
                movies.add(movieListEntityToDto(movieEntity));
            }
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        return movies;
    }


    @Override
    public Page findPages(Pageable pageable){

           return movieRepository.findAll(pageable);
    }

    @Override
    public Long getMovieCount() {
        Long movieCount = 0L;
        try {
            movieCount = movieRepository.count();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movieCount;
    }
    @Override
    public Long getCategoryMovieCount(String category) {
        Long movieCount = 0L;
        try {
            movieCount = movieRepository.getMovieByCategory(category).stream().count();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movieCount;
    }

    @Override
    public  Long getLanguageMovieCount(String language){
        Long movieCount = 0L;
        try {
            movieCount = movieRepository.getMovieByLanguage(language).stream().count();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movieCount;
    }



    @Override
    public void saveMovieIntoDb(MovieEntity movieEntity) {
        try {
            movieRepository.save(movieEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Page<MovieEntity> findPaginated(int pageNo, int pageSize) {

        Pageable moviePages = PageRequest.of(pageNo - 1, pageSize);

        return this.movieRepository.findAll(moviePages);
    }

    @Override
    public Page findActionMoviePages(Pageable pageable){
        return this.movieRepository.findByName("Action",pageable);
    }

    @Override
    public void deleteFromDb(int id) {
        try {
            movieRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public MovieEntity getByID(int id) {
        return movieRepository.findById(id).orElse(null);
    }

    @Override
    public void movieUpdateToDb(MovieEntity movie) {
        MovieEntity mv = get(movie.getId());
        mv.setName(movie.getName());
        mv.setCategory(movie.getCategory());
        mv.setMovieId(movie.getMovieId());
        mv.setRating(movie.getRating());
        mv.setLanguage(movie.getLanguage());
        try {
            movieRepository.save(mv);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public  void saveAdminData(Admin admin){
        AdminEntity adminEntity = new AdminEntity();
        
        try {
            adminEntity = adminDtoToEntity(admin);
            adminRepository.save(adminEntity);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    private AdminEntity adminDtoToEntity(Admin admin) {
        AdminEntity adminEntity = new AdminEntity();
        adminEntity.setAdmin_email(admin.getAdmin_email());
        adminEntity.setAdmin_password(admin.getAdmin_password());
        return  adminEntity;
    }

    private Movie movieListEntityToDto(MovieEntity movieEntity) {
        Movie movie = new Movie();
        movie.setId(movieEntity.getId());
        movie.setName(movieEntity.getName());
        movie.setCategory(movieEntity.getCategory());
        movie.setMovieId(movieEntity.getMovieId());
        movie.setRating(movieEntity.getRating());
        movie.setLanguage(movieEntity.getLanguage());
        return movie;
    }



    public MovieEntity get(int id) {
        return movieRepository.findById(id).orElse(null);
    }
}
