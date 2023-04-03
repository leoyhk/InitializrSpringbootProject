/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leoyuen.Lab3;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author leoyuen
 */

@RestController
@RequestMapping(value="/api/movies")
public class MovieController {
    private MovieDao movieDao;
    
    MovieController(MovieDao movieDao){
        this.movieDao = movieDao;
    }
    
    @GetMapping(value = "", produces = "application/json")
    public List<Movie> getMovies(){
        return movieDao.getMovie();
    }
    
    @PutMapping(value = "/{id}")
    public void updateMovie(@PathVariable int id, @RequestBody Movie movie){
        movie.setId(id);
        movieDao.updateMovie(movie);
    }
    
    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable int id) {
        movieDao.deleteMovie(id);
    }

    
    
}
