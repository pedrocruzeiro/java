package org.pedro.cruzeiro.developer.trie;

import org.pedro.cruzeiro.developer.dto.MovieDetails;

import java.util.HashMap;
import java.util.Map;

public class TrieMovieNode {
  private final HashMap<Character, TrieMovieNode> children;

  private MovieDetails movieDetails;
  private boolean isTitle;

  TrieMovieNode() {
    this.children = new HashMap<>();
    this.isTitle = false;
  }

  public Map<Character, TrieMovieNode> getChildren() {
    return children;
  }

  public void setIstTitle(boolean value) {
    this.isTitle = value;
  }

  public void setMovieDetails(String name, String category) {
    this.movieDetails = new MovieDetails(name, category);
  }

  public MovieDetails getMovieDetails() {
    return movieDetails;
  }

  public boolean isTitle() {
    return this.isTitle;
  }
}
