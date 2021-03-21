package com.company.controller;

import org.springframework.web.bind.annotation.RestController;
import com.company.model.WordOfTheDay;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class WordOfTheDayController {
    private List<WordOfTheDay> wordOfTheDayList;

    private static int idCounter = 0;

    public WordOfTheDayController(){
        wordOfTheDayList = new ArrayList<>();

        wordOfTheDayList.add(new WordOfTheDay("Jobbernowl","a blockish or stupid head",idCounter++));
        wordOfTheDayList.add(new WordOfTheDay("Locomobile","self-propelling machine; early automobile",idCounter++));
        wordOfTheDayList.add(new WordOfTheDay("Balzarine","light cotton dress material",idCounter++));
        wordOfTheDayList.add(new WordOfTheDay("Keloid","hard scar tissue which grows over injured skin",idCounter++));
        wordOfTheDayList.add(new WordOfTheDay("Zoopery","experimentation on animals",idCounter++));
        wordOfTheDayList.add(new WordOfTheDay("Wyrd","the personification of fate or destiny",idCounter++));
        wordOfTheDayList.add(new WordOfTheDay("Rillet","small brook or stream",idCounter++));
        wordOfTheDayList.add(new WordOfTheDay("Yeo","stream or drain used in mining",idCounter++));
        wordOfTheDayList.add(new WordOfTheDay("Kakaki","West African ceremonial trumpet",idCounter++));
        wordOfTheDayList.add(new WordOfTheDay("Bongo","reddish African antelope with white vertical stripes",idCounter++));

    }

    public void clearWordOfTheDay(){
        wordOfTheDayList.clear();
    }
    public void addWord(WordOfTheDay word){
        wordOfTheDayList.add(word);
    }
    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus( value = HttpStatus.OK)
    public WordOfTheDay getWordOfTheDayList(){
        Random random = new Random();
        int randomIndex = random.nextInt(wordOfTheDayList.size());
        return wordOfTheDayList.get(randomIndex);
    }

}
