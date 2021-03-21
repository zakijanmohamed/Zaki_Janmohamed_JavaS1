package com.company.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class QuoteOfTheDay {

    @NotEmpty(message = "You must supply a quote.")
    private String quote;
    @NotEmpty(message = "You must supply an author.")
    private String author;
    @Min(value = 1, message = "You must supply event Id.")
    private int id;

    public QuoteOfTheDay() {

    }

    public QuoteOfTheDay(String quote, String author, int id) {
        this.quote = quote;
        this.author = author;
        this.id = id;


    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
