package com.company.controller;

import com.company.model.Magic8;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class Magic8Controller {
    private List<Magic8> aList = new ArrayList<Magic8>();
    //private Word word;

    public void clearQ(){
        aList.clear();
    }

    public void addA(Magic8 a){
        aList.add(a);
    }

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Magic8 addQ(@RequestBody @Valid Magic8 q){
        Random random = new Random();
        int randomIndex = random.nextInt(aList.size());
        String s = q.getQuestion();
        Magic8 temp = aList.get(randomIndex);
        temp.setQuestion(s);
        return temp;

    }



}
