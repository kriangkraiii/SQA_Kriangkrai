package com.sqa.lab9.service;

import com.sqa.lab9.model.Movie;
import java.util.List;

/**
 * MovieService interface
 * kriangkrai prasert
 * 663380616-4
 */
public interface MovieService {
    List<Movie> getMoviesByUsername(String username);
}
