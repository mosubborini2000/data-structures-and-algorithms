/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package movie;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
    @Test
    public void testSortByYearDescending() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Movie A", 2022, List.of("Genre1", "Genre2")));
        movies.add(new Movie("Movie B", 2020, List.of("Genre3", "Genre4")));

        Collections.sort(movies, MovieComparators.sortByYearDescending());

        assertEquals( 2022, movies.get(0).getYear());
        assertEquals( 2020, movies.get(1).getYear());
    }

    @Test
    public void testSortByTitleIgnoringWords() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("The Amazing Spider-man", 2012, List.of("Action", "Adventure")));
        movies.add(new Movie("The Dark Knight", 2008, List.of("Action", "Drama")));
        movies.add(new Movie("The Godfather", 1972, List.of("Crime", "Drama")));
        movies.add(new Movie("Inception", 2010, List.of("Action", "Sci-Fi")));
        movies.add(new Movie("Pulp Fiction", 1994, List.of("Crime", "Drama")));

        List<String> ignoredWords = Arrays.asList("A", "An", "The");
        Collections.sort(movies, MovieComparators.sortByTitleIgnoringWords(ignoredWords));

        assertEquals( "The Amazing Spider-man", movies.get(0).getTitle());
        assertEquals( "The Dark Knight", movies.get(1).getTitle());
        assertEquals( "The Godfather", movies.get(2).getTitle());
        assertEquals( "Inception", movies.get(3).getTitle());
        assertEquals( "Pulp Fiction", movies.get(4).getTitle());
    }

}
