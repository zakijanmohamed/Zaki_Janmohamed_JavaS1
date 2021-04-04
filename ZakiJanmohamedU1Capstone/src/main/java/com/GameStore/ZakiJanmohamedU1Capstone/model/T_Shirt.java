package com.GameStore.ZakiJanmohamedU1Capstone.model;

import nonapi.io.github.classgraph.json.Id;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class T_Shirt {

    @NotNull
    private int t_shirt_id;
    @NotEmpty(message = "You must supply a size for the T-Shirt.")
    @Size(max = 20, message = "The size can only be up to 20 characters.")
    private String size;
    @NotEmpty(message = "You must supply a color for the T-Shirt.")
    @Size(max = 20, message = "The color can only be up to 20 characters.")
    private String color;
    @NotEmpty(message = "You must supply a description for the T-Shirt.")
    @Size(max = 255, message = "The description can only be up to 20 characters.")
    private String description;
    @DecimalMin(value ="1",message = "The price must be greater than 1")
    @Digits(integer = 5,fraction = 2,message = "Your price cannot be larger than $99,999.99")
    private BigDecimal price;
    @Positive(message = "You must supply a value equals to, or greater than 1 for the quantity.")
    private int quantity;

    public int getT_shirt_id() {
        return t_shirt_id;
    }

    public void setT_shirt_id(int t_shirt_id) {
        this.t_shirt_id = t_shirt_id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
        T_Shirt t_shirt = (T_Shirt) o;
        return t_shirt_id == t_shirt.t_shirt_id && quantity == t_shirt.quantity && Objects.equals(size, t_shirt.size) && Objects.equals(color, t_shirt.color) && Objects.equals(description, t_shirt.description) && Objects.equals(price, t_shirt.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(t_shirt_id, size, color, description, price, quantity);
    }

    @Override
    public String toString() {
        return "T_Shirt{" +
                "t_shirt_id=" + t_shirt_id +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
