package org.pedro.cruzeiro.developer.trie;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pedro.cruzeiro.developer.dto.MovieDetails;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TrieMovieCatalogTest {

  private static final String HOME_ALONE = "Home Alone";
  private static final String HOME_COMING = "Home Coming";
  private static final String HAVING_FUN = "Having Fun";
  private static final String ALINE_3 = "Alien 3";
  private static final String BATMAN_BEGINS = "Batman Begins";
  private static final String ADVENTURE_CATEGORY = "Adventure";
  private static final String FICTION_CATEGORY = "Fiction";

  @DisplayName("Insert Single Movie")
  @Test
  void testInsertSingleMovie() {

    TrieMovieCatalog trieMovieCatalog = new TrieMovieCatalog();

    trieMovieCatalog.insert(HOME_ALONE, ADVENTURE_CATEGORY);

    assertTrue(trieMovieCatalog.containsMovie(HOME_ALONE));
  }

  @DisplayName("Get Single Movie Details")
  @Test
  void testGetSingleMovie() {

    TrieMovieCatalog trieMovieCatalog = new TrieMovieCatalog();

    trieMovieCatalog.insert(HOME_ALONE, ADVENTURE_CATEGORY);

    assertTrue(trieMovieCatalog.containsMovie(HOME_ALONE));

    MovieDetails movieDetails = trieMovieCatalog.getMovieDetails(HOME_ALONE);

    assertEquals(HOME_ALONE, movieDetails.getName());

    assertEquals(ADVENTURE_CATEGORY, movieDetails.getCategory());
  }

  @DisplayName("Insert Two Movies")
  @Test
  void testInsertTwoMovies() {

    TrieMovieCatalog trieMovieCatalog = new TrieMovieCatalog();

    trieMovieCatalog.insert(HOME_ALONE, ADVENTURE_CATEGORY);
    trieMovieCatalog.insert(HOME_COMING, FICTION_CATEGORY);

    assertTrue(
        trieMovieCatalog.containsMovie(HOME_ALONE),
        String.format("Movie [%s] not present.", HOME_ALONE));
    assertTrue(
        trieMovieCatalog.containsMovie(HOME_COMING),
        String.format("Movie [%s] not present.", HOME_COMING));

    assertEquals(2, trieMovieCatalog.countMoviesInCatalog());
  }

  @DisplayName("Insert Movies And Delete One")
  @Test
  void testInsertMoviesAndDeleteOne() {

    TrieMovieCatalog trieMovieCatalog = new TrieMovieCatalog();

    trieMovieCatalog.insert(HOME_ALONE, ADVENTURE_CATEGORY);
    trieMovieCatalog.insert(HOME_COMING, FICTION_CATEGORY);
    trieMovieCatalog.insert(HAVING_FUN, ADVENTURE_CATEGORY);
    trieMovieCatalog.insert(ALINE_3, FICTION_CATEGORY);
    trieMovieCatalog.insert(BATMAN_BEGINS, ADVENTURE_CATEGORY);

    assertEquals(5, trieMovieCatalog.countMoviesInCatalog());

    trieMovieCatalog.delete(HOME_ALONE);

    assertEquals(4, trieMovieCatalog.countMoviesInCatalog());
  }

  @DisplayName("Insert Three Movies and return Two matching prefix")
  @Test
  void testInsertThreeMoviesAndReturnTwoMatchingPrefix() {

    TrieMovieCatalog trieMovieCatalog = new TrieMovieCatalog();

    trieMovieCatalog.insert(HOME_ALONE, ADVENTURE_CATEGORY);
    trieMovieCatalog.insert(HOME_COMING, ADVENTURE_CATEGORY);
    trieMovieCatalog.insert(HAVING_FUN, ADVENTURE_CATEGORY);

    assertTrue(
        trieMovieCatalog.containsMovie(HOME_ALONE),
        String.format("Movie [%s] not present.", HOME_ALONE));
    assertTrue(
        trieMovieCatalog.containsMovie(HOME_COMING),
        String.format("Movie [%s] not present.", HOME_COMING));
    assertTrue(
        trieMovieCatalog.containsMovie(HAVING_FUN),
        String.format("Movie [%s] not present.", HAVING_FUN));

    assertEquals(3, trieMovieCatalog.countMoviesInCatalog());

    assertEquals(2, trieMovieCatalog.countMatchingWithPrefix("Ho"));
  }
}
