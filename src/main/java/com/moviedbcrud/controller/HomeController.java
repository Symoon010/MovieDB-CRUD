package com.moviedbcrud.controller;

import com.moviedbcrud.model.dto.Admin;
import com.moviedbcrud.model.dto.Movie;
import com.moviedbcrud.model.entity.AdminEntity;
import com.moviedbcrud.model.entity.MovieEntity;
import com.moviedbcrud.repository.MovieRepository;
import com.moviedbcrud.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/")
    public  String getSignIn(){
        return "index.html";
    }

    @PostMapping("/login")
    public  String getSignInByAuth(@ModelAttribute Admin admin){
        if(movieService.checkAuthentication(admin)){
            return "redirect:/index";
        }
        else{
            return "redirect:/login";
        }
    }
    @GetMapping("/sign-up")
    public  String getSignUp(){
        return "sign-up.html";
    }
    @PostMapping("/sign-up")
    public  String getSignUpByAuth(@ModelAttribute Admin admin){
        movieService.saveAdminData(admin);
        return "redirect:/login";
    }

    @GetMapping("/index")
    public  ModelAndView movieDashboard(){
        ModelAndView modelAndView= new ModelAndView();
        Long movieCount = movieService.getMovieCount();

        modelAndView.setViewName("index.html");
        modelAndView.addObject("totalMovieCount",movieCount);
        modelAndView.addObject("actionMovieCount",movieService.getCategoryMovieCount("Action"));
        modelAndView.addObject("comedyMovieCount",movieService.getCategoryMovieCount("Comedy"));
        modelAndView.addObject("englishMovieCount",movieService.getLanguageMovieCount("English"));
        return modelAndView;
    }

    @GetMapping("/list-movie")
    public  String listMovie(Model model,@PageableDefault(size = 5) Pageable pageable){
          ModelAndView modelAndView = new ModelAndView();
          modelAndView.setViewName("movie-update-modal");
          Page page = movieService.findPages(pageable);
          model.addAttribute("data",page);
          return  "list-movie";
    }
    @GetMapping("/action-movie")
    public  ModelAndView actionMovieList(Model model){
        List<Movie>movieList = movieService.getMovieByCategory("Action");
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("action-movies.html");
        modelAndView.addObject("data",movieList);
        return   modelAndView;
    }

    @GetMapping("/comedy-movies")
    public  ModelAndView comedyMovieList(@ModelAttribute MovieEntity movieEntity){
        List<Movie>movieList = movieService.getMovieByCategory("Comedy");
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("comedy-movie.html");
        modelAndView.addObject("data",movieList);
        return   modelAndView;
    }
    @GetMapping("/english-movies")
    public  ModelAndView englishMovieList(@ModelAttribute MovieEntity movieEntity){
        List<Movie>movieList = movieService.getEnglishMovies();
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("english-movies.html");
        modelAndView.addObject("data",movieList);
        return   modelAndView;
    }
    @GetMapping("/add-movie")
    public  String addMovie(){
        return "add-movie.html";
    }

    @PostMapping("/add-movie")
    public  String saveAddMovie(@ModelAttribute MovieEntity movieEntity){
        movieService.saveMovieIntoDb(movieEntity);
        return "redirect:/list-movie";
    }

    @GetMapping("/update-movie")
    public ModelAndView getUpdateMoviePage(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("update-modal.html");
        modelAndView.addObject("id", id);
        modelAndView.addObject("movie", movieService.getByID(id));
        return modelAndView;
    }
    @PostMapping("/update-movie/{id}")
    public String updateMoviePage(@ModelAttribute MovieEntity movie){
        movieService.movieUpdateToDb(movie);
        String category = movie.getCategory();
        if(category.equals("Action")){
            return "redirect:/action-movie";
        }
        else if(category.equals("Comedy")){
            return "redirect:/comedy-movies";
        }
        else if(category.equals("English")){
            return "redirect:/english-movies";
        }
       else{
            return "redirect:/list-movie.html";
        }
    }
    @GetMapping("/delete/{id}")
    public String deleteMoviePage(@PathVariable(name = "id") int id){
        movieService.deleteFromDb(id);
        return "redirect:/list-movie";
    }
}
