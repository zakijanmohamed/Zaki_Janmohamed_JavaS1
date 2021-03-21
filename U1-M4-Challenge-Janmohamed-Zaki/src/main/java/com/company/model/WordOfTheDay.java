package com.company.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class WordOfTheDay {
    @NotEmpty(message = "You must supply a word.")
    private String word;
    @NotEmpty(message = "You must supply a definition.")
    private String definition;
    @Min(value = 1, message = "You must supply event Id.")
    private int id;

    public WordOfTheDay(){

    }
    public WordOfTheDay(String word,String definition, int id){
        this.word = word;
        this.definition = definition;
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
