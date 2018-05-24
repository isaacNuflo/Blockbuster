/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author LABO08
 */
public class Film {
    private Integer id;
    private String title;
    private String description;
    private String release_year;
    private String language;
    private Integer rental_duration;
    private Integer length;
    private String rating;
    private Double costo_reemplazo;
    private Double precio;
    private Integer disponible;
    private String special_features;

    public Film(Integer id, String title, String description, String release_year, String language, Integer rental_duration, Integer length, String rating, Double costo_reemplazo, Double precio, Integer disponible, String special_features) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.release_year = release_year;
        this.language = language;
        this.rental_duration = rental_duration;
        this.length = length;
        this.rating = rating;
        this.costo_reemplazo = costo_reemplazo;
        this.precio = precio;
        this.disponible = disponible;
        this.special_features = special_features;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRelease_year() {
        return release_year;
    }

    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getRental_duration() {
        return rental_duration;
    }

    public void setRental_duration(Integer rental_duration) {
        this.rental_duration = rental_duration;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Double getCosto_reemplazo() {
        return costo_reemplazo;
    }

    public void setCosto_reemplazo(Double costo_reemplazo) {
        this.costo_reemplazo = costo_reemplazo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getDisponible() {
        return disponible;
    }

    public void setDisponible(Integer disponible) {
        this.disponible = disponible;
    }

    public String getSpecial_features() {
        return special_features;
    }

    public void setSpecial_features(String special_features) {
        this.special_features = special_features;
    }
}
