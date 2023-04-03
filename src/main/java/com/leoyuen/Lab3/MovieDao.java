/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leoyuen.Lab3;

import java.text.DecimalFormat;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author konoleoda
 */
public class MovieDao {

    private JdbcTemplate jdbcTemplate;

    public MovieDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Movie> getMovie() {
String sql = "SELECT * FROM movies";
    List<Movie> movies = jdbcTemplate.query(sql, (rs, rowNum) ->
      new Movie(
        rs.getInt("ID"),
        rs.getString("NAME"),
        rs.getInt("YEAR"),
        Float.parseFloat(String.format("%.1f", rs.getFloat("RANK")))
      )
    );
    return movies;
  }

    public void updateMovie(Movie movie) {
        String sql = "UPDATE movies SET name = ?, \"year\" = ?, RANK = ? WHERE id = ?";
        jdbcTemplate.update(sql, movie.getName(), movie.getYear(), movie.getRank(), movie.getId());
    }

    public void deleteMovie(int movieId) {
        String sql = "DELETE FROM movies WHERE id = ?";
        jdbcTemplate.update(sql, movieId);
    }

}
