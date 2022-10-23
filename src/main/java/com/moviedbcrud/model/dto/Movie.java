package com.moviedbcrud.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Movie {
    private  int id;
    private  String name;
    private  String category;
    private  int movieId;
    private Double rating;
    private  String language;

}
