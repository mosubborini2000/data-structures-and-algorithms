package movie;

import java.util.Comparator;
import java.util.List;

public class MovieComparators {
    public static Comparator<Movie> sortByYearDescending() {
        return (movie1, movie2) -> Integer.compare(movie2.getYear(), movie1.getYear());
    }

    public static Comparator<Movie> sortByTitleIgnoringWords(List<String> ignoredWords) {
        return (movie1, movie2) -> {
            String title1 = movie1.getTitle();
            String title2 = movie2.getTitle();

            for (String word : ignoredWords) {
                title1 = title1.replaceAll("(?i)\\b" + word + "\\b", "").trim();
                title2 = title2.replaceAll("(?i)\\b" + word + "\\b", "").trim();
            }

            int result= title1.compareToIgnoreCase(title2);
            if (result == 0) {
                return movie1.getTitle().compareToIgnoreCase(movie2.getTitle());
            }

            return result;
        };
    }
}
