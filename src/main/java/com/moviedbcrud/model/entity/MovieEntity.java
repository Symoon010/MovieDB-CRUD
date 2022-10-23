package com.moviedbcrud.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Movie_lIST")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private  int id;
    private  String name;
    private  String category;
    private  int movieId;
    private Double rating;
    private  String language;
}
