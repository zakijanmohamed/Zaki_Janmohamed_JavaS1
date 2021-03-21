package com.company.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Magic8 {

    @Min(value = 1,message = "You must supply the id.")
    private int id;
    @NotEmpty(message = "You must supply a question")
    private String question;
    @NotEmpty(message = "You must supply a answer")
    private String answer;

    public Magic8(){

    }
    public Magic8(int id, String answer){
        this.id = id;
        this.answer = answer;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}



