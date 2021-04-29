package com.GameStore.ZakiJanmohamedU1Capstone.model;

import nonapi.io.github.classgraph.json.Id;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class Console {

    @NotNull
    private int console_id;
    @NotEmpty(message = "You must supply a model for the console.")
    @Size(max = 50, message = "The model can only be up to 50 characters.")
    private String model;
    @NotEmpty(message = "You must supply a manufacturer for the console.")
    @Size(max = 50, message = "The manufacturer can only be up to 50 characters.")
    private String manufacturer;
    @NotEmpty(message = "You must supply a memory amount for the console.")
    @Size(max = 20, message = "The memory amount can only be up to 20 characters.")
    private String memory_amount;
    @NotEmpty(message = "You must supply a processor for the console.")
    @Size(max = 20, message = "The processor can only be up to 20 characters.")
    private String processor;
    @DecimalMin(value ="0.01",message = "The price must be a positive non-zero value.")
    @Digits(integer = 5,fraction = 2,message = "Your total cannot be larger than $99,999.99")
    private BigDecimal price;
    @Positive (message = "You must supply a value equals to, or greater than 1 for the quantity.")
    private int quantity;

    public int getConsole_id() {
        return console_id;
    }

    public void setConsole_id(int console_id) {
        this.console_id = console_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemory_amount() {
        return memory_amount;
    }

    public void setMemory_amount(String memory_amount) {
        this.memory_amount = memory_amount;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
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
        Console console = (Console) o;
        return console_id == console.console_id && quantity == console.quantity && Objects.equals(model, console.model) && Objects.equals(manufacturer, console.manufacturer) && Objects.equals(memory_amount, console.memory_amount) && Objects.equals(processor, console.processor) && Objects.equals(price, console.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(console_id, model, manufacturer, memory_amount, processor, price, quantity);
    }

    @Override
    public String toString() {
        return "Console{" +
                "console_id=" + console_id +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", memory_amount='" + memory_amount + '\'' +
                ", processor='" + processor + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
