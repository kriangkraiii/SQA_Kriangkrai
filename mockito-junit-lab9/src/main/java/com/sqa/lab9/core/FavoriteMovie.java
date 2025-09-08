package com.sqa.lab9.core;

import com.sqa.lab9.model.Movie;
import com.sqa.lab9.service.MovieService;
import java.util.List;
import java.util.stream.Collectors;

/**
 * FavoriteMovie class
 * kriangkrai prasert
 * 663380616-4
 */
public class FavoriteMovie {
    private MovieService movieService;

    public FavoriteMovie(MovieService movieService) {
        this.movieService = movieService;
    }

    public String getMoviesByPlaylist(String username, String playlist) {
        List<Movie> movies = movieService.getMoviesByUsername(username);
        
        List<String> filteredMovies = movies.stream()
                .filter(movie -> movie.getPlaylist().equalsIgnoreCase(playlist))
                .map(Movie::getTitle)
                .collect(Collectors.toList());
        
        return String.join(", ", filteredMovies);
    }

    public String getMoviesByGenre(String username, String genre) {
        List<Movie> movies = movieService.getMoviesByUsername(username);
        
        List<String> filteredMovies = movies.stream()
                .filter(movie -> movie.getGenre().equalsIgnoreCase(genre))
                .map(Movie::getTitle)
                .collect(Collectors.toList());
        
        return String.join(", ", filteredMovies);
    }
}
