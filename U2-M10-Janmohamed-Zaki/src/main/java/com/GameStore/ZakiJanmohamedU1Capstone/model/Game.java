package com.GameStore.ZakiJanmohamedU1Capstone.model;

import nonapi.io.github.classgraph.json.Id;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class Game {

    @NotNull
    private int game_id;
    @NotEmpty(message = "You must supply a title for the game.")
    @Size(max = 50, message = "The title can only be up to 50 characters.")
    private String title;
    @NotEmpty(message = "You must supply an ESRB rating for the game.")
    @Size(max = 50, message = "The model can only be up to 50 characters.")
    private String esrb_rating;
    @NotEmpty(message = "You must supply a description for the game.")
    @Size(max = 255, message = "The model can only be up to 255 characters.")
    private String description;
    @DecimalMin(value ="0.01",message = "The price must be a positive non-zero value.")
    @Digits(integer = 5,fraction = 2,message = "Your total cannot be larger than $99,999.99")
    private BigDecimal price;
    @NotEmpty(message = "You must supply a studio for the game.")
    @Size(max = 50, message = "The studio can only be up to 50 characters.")
    private String studio;
    @Positive(message = "You must supply a value equals to, or greater than 1 for the quantity.")
    private int quantity;

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEsrb_rating() {
        return esrb_rating;
    }

    public void setEsrb_rating(String esrb_rating) {
        this.esrb_rating = esrb_rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return game_id == game.game_id && quantity == game.quantity && Objects.equals(title, game.title) && Objects.equals(esrb_rating, game.esrb_rating) && Objects.equals(description, game.description) && Objects.equals(price, game.price) && Objects.equals(studio, game.studio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game_id, title, esrb_rating, description, price, studio, quantity);
    }

    @Override
    public String toString() {
        return "Game{" +
                "game_id=" + game_id +
                ", title='" + title + '\'' +
                ", esrb_rating='" + esrb_rating + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", studio='" + studio + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
