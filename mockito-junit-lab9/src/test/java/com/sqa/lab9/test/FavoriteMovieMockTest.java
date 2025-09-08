package com.sqa.lab9.test;

import com.sqa.lab9.core.FavoriteMovie;
import com.sqa.lab9.model.Movie;
import com.sqa.lab9.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class FavoriteMovieMockTest {
    
    @Mock
    private MovieService movieService;
    
    private FavoriteMovie favoriteMovie;
    
    @BeforeEach
    void setUp() {
        favoriteMovie = new FavoriteMovie(movieService);
    }
    
    @Test
    void testGetMoviesByGenre_Action_WithMock() {
        // Arrange
        String username = "testuser";
        List<Movie> mockMovies = Arrays.asList(
            new Movie("The Avengers", "action", "action"),
            new Movie("Iron Man", "action", "action"),
            new Movie("Captain America", "action", "action"),
            new Movie("Thor", "action", "action"),
            new Movie("The Notebook", "romance", "datenight")
        );
        
        when(movieService.getMoviesByUsername(username)).thenReturn(mockMovies);
        
        // Act
        String result = favoriteMovie.getMoviesByGenre(username, "action");
        
        // Assert
        String expected = "The Avengers, Iron Man, Captain America, Thor";
        assertEquals(expected, result);
        
        // Verify interaction
        verify(movieService, times(1)).getMoviesByUsername(username);
    }
    
    @Test
    void testGetMoviesByPlaylist_DateNight_WithMock() {
        // Arrange
        String username = "testuser";
        List<Movie> mockMovies = Arrays.asList(
            new Movie("The Notebook", "romance", "datenight"),
            new Movie("50 First Dates", "romance", "datenight"),
            new Movie("A Walk to Remember", "romance", "datenight"),
            new Movie("The Avengers", "action", "action")
        );
        
        when(movieService.getMoviesByUsername(username)).thenReturn(mockMovies);
        
        // Act
        String result = favoriteMovie.getMoviesByPlaylist(username, "datenight");
        
        // Assert
        String expected = "The Notebook, 50 First Dates, A Walk to Remember";
        assertEquals(expected, result);
        
        // Verify interaction
        verify(movieService, times(1)).getMoviesByUsername(username);
    }
    
    @Test
    void testGetMoviesByGenre_Horror_WithMock() {
        // Arrange
        String username = "testuser";
        List<Movie> mockMovies = Arrays.asList(
            new Movie("The Conjuring", "horror", "horror"),
            new Movie("Insidious", "horror", "horror"),
            new Movie("The Avengers", "action", "action")
        );
        
        when(movieService.getMoviesByUsername(username)).thenReturn(mockMovies);
        
        // Act
        String result = favoriteMovie.getMoviesByGenre(username, "horror");
        
        // Assert
        String expected = "The Conjuring, Insidious";
        assertEquals(expected, result);
        
        // Verify interaction
        verify(movieService, times(1)).getMoviesByUsername(username);
    }
    
    @Test
    void testEmptyResult_WhenNoMatchingGenre() {
        // Arrange
        String username = "testuser";
        List<Movie> mockMovies = Arrays.asList(
            new Movie("The Notebook", "romance", "datenight")
        );
        
        when(movieService.getMoviesByUsername(username)).thenReturn(mockMovies);
        
        // Act
        String result = favoriteMovie.getMoviesByGenre(username, "comedy");
        
        // Assert
        assertEquals("", result);
        
        // Verify interaction
        verify(movieService, times(1)).getMoviesByUsername(username);
    }
}
