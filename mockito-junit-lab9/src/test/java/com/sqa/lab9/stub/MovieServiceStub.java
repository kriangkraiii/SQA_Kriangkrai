package com.sqa.lab9.stub;

import com.sqa.lab9.model.Movie;
import com.sqa.lab9.service.MovieService;
import java.util.Arrays;
import java.util.List;

/**
 * MovieServiceStub class
 * kriangkrai prasert
 * 663380616-4
 */
public class MovieServiceStub implements MovieService {
    
    @Override
    public List<Movie> getMoviesByUsername(String username) {
        return Arrays.asList(
            new Movie("The Notebook", "romance", "datenight"),
            new Movie("50 First Dates", "romance", "datenight"),
            new Movie("A Walk to Remember", "romance", "datenight"),
            new Movie("First Love", "romance", "datenight"),
            new Movie("The Lucky One", "romance", "datenight"),
            new Movie("The Conjuring", "horror", "horror"),
            new Movie("Insidious", "horror", "horror"),
            new Movie("Annabelle", "horror", "horror"),
            new Movie("The Avengers", "action", "action"),
            new Movie("Iron Man", "action", "action"),
            new Movie("Captain America", "action", "action"),
            new Movie("Thor", "action", "action")
        );
    }
}
