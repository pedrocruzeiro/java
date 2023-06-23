package org.pedro.cruzeiro.developer.dto;

public class MovieDetails {
    private String name;
    private String category;

    public MovieDetails(String name, String category){
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }
}
