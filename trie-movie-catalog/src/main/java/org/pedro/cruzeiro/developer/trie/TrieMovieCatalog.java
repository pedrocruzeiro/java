package org.pedro.cruzeiro.developer.trie;

import org.pedro.cruzeiro.developer.dto.MovieDetails;

import java.util.ArrayList;
import java.util.List;

public class TrieMovieCatalog {

  TrieMovieNode root;

  public TrieMovieCatalog() {
    root = new TrieMovieNode();
  }

  public void insert(String movieTitle,String category) {
    TrieMovieNode current = root;

    for (char l : movieTitle.toCharArray()) {
      current = current.getChildren().computeIfAbsent(l, c -> new TrieMovieNode());
    }
    current.setMovieDetails(movieTitle,category);
    current.setIstTitle(true);
  }

  public boolean containsMovie(String movieTitle) {
    TrieMovieNode current = root;

    for (int i = 0; i < movieTitle.length(); i++) {
      char ch = movieTitle.charAt(i);
      TrieMovieNode node = current.getChildren().get(ch);
      if (node == null) {
        return false;
      }
      current = node;
    }
    return current.isTitle();
  }

  public MovieDetails getMovieDetails(String movieTitle) {

    TrieMovieNode current = root;

    for (int i = 0; i < movieTitle.length(); i++) {
      char ch = movieTitle.charAt(i);
      TrieMovieNode node = current.getChildren().get(ch);
      if (node == null) {
        return null;
      }
      current = node;
    }


    return current.getMovieDetails();
  }

  public void delete(String movie) {
    delete(root, movie, 0);
  }

  private boolean delete(TrieMovieNode current, String movie, int index) {
    if (index == movie.length()) {
      if (!current.isTitle()) {
        return false;
      }
      current.setIstTitle(false);
      return current.getChildren().isEmpty();
    }
    char ch = movie.charAt(index);
    TrieMovieNode node = current.getChildren().get(ch);
    if (node == null) {
      return false;
    }
    boolean shouldDeleteCurrentNode = delete(node, movie, index + 1) && !node.isTitle();

    if (shouldDeleteCurrentNode) {
      current.getChildren().remove(ch);
      return current.getChildren().isEmpty();
    }
    return false;
  }

  public int countMatchingWithPrefix(String prefix) {
    return searchMoviesWithPrefix(prefix).size();
  }

  // Search for words starting with the given prefix
  public List<String> searchMoviesWithPrefix(String prefix) {
    List<String> results = new ArrayList<>();
    TrieMovieNode prefixNode = findPrefixNode(prefix);
    if (prefixNode != null) {
      if (prefixNode.isTitle()) results.add(prefix);

      collectMovies(prefixNode, new StringBuilder(prefix), results);
    }
    return results;
  }

  // Find the node corresponding to the given prefix
  private TrieMovieNode findPrefixNode(String prefix) {
    TrieMovieNode current = root;
    for (char ch : prefix.toCharArray()) {
      if (!current.getChildren().containsKey(ch)) return null;
      current = current.getChildren().get(ch);
    }
    return current;
  }

  // Collect all words starting from the given node
  private void collectMovies(TrieMovieNode node, StringBuilder sb, List<String> results) {
    if (node.isTitle()) results.add(sb.toString());

    for (char ch : node.getChildren().keySet()) {
      sb.append(ch);
      collectMovies(node.getChildren().get(ch), sb, results);
      sb.deleteCharAt(sb.length() - 1);
    }
  }

  public int countMoviesInCatalog() {
    return countMoviesInMovieNode(root);
  }

  private int countMoviesInMovieNode(TrieMovieNode node) {
    int count = 0;
    if (node.isTitle()) {
      count++;
    }
    for (TrieMovieNode child : node.getChildren().values()) {
      count += countMoviesInMovieNode(child);
    }
    return count;
  }
}
