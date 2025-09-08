package com.sqa.lab9.test;

import com.sqa.lab9.core.FavoriteMovie;
import com.sqa.lab9.service.MovieService;
import com.sqa.lab9.stub.MovieServiceStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class FavoriteMovieStubTest {
    
    private FavoriteMovie favoriteMovie;
    private MovieService movieServiceStub;
    
    @BeforeEach
    void setUp() {
        movieServiceStub = new MovieServiceStub();
        favoriteMovie = new FavoriteMovie(movieServiceStub);
    }
    
    @Test
    void testGetMoviesByPlaylist_DateNight() {
        String result = favoriteMovie.getMoviesByPlaylist("testuser", "datenight");
        String expected = "The Notebook, 50 First Dates, A Walk to Remember, First Love, The Lucky One";
        
        assertEquals(expected, result);
    }
    
    @Test
    void testGetMoviesByPlaylist_Horror() {
        String result = favoriteMovie.getMoviesByPlaylist("testuser", "horror");
        String expected = "The Conjuring, Insidious, Annabelle";
        
        assertEquals(expected, result);
    }
    
    @Test
    void testGetMoviesByGenre_Action() {
        String result = favoriteMovie.getMoviesByGenre("testuser", "action");
        String expected = "The Avengers, Iron Man, Captain America, Thor";
        
        assertEquals(expected, result);
    }
    
    @Test
    void testGetMoviesByGenre_Romance() {
        String result = favoriteMovie.getMoviesByGenre("testuser", "romance");
        String expected = "The Notebook, 50 First Dates, A Walk to Remember, First Love, The Lucky One";
        
        assertEquals(expected, result);
    }
}
