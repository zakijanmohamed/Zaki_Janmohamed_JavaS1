package com.company.controller;

import org.springframework.web.bind.annotation.RestController;
import com.company.model.QuoteOfTheDay;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class QuoteOfTheDayController {
    private List<QuoteOfTheDay> quoteOfTheDayList;

    private static int idCounter = 0;

    public QuoteOfTheDayController(){
        quoteOfTheDayList = new ArrayList<>();

        quoteOfTheDayList.add(new QuoteOfTheDay("The road to success is always under construction."," Lily Tomlin",idCounter++));
        quoteOfTheDayList.add(new QuoteOfTheDay("I’m in shape. Round is a shape."," George Carlin",idCounter++));
        quoteOfTheDayList.add(new QuoteOfTheDay("If you try to fail and succeed, which have you done?"," George Carlin",idCounter++));
        quoteOfTheDayList.add(new QuoteOfTheDay("Never miss a good chance to shut up.","Will Rogers",idCounter++));
        quoteOfTheDayList.add(new QuoteOfTheDay("Why is there so much month left at the end of the money?","John Barrymore",idCounter++));
        quoteOfTheDayList.add(new QuoteOfTheDay("Never go to bed mad. Stay up and fight.","Phyllis Diller",idCounter++));
        quoteOfTheDayList.add(new QuoteOfTheDay("Accept who you are. Unless you’re a serial killer.","Ellen DeGeneres",idCounter++));
        quoteOfTheDayList.add(new QuoteOfTheDay("Procrastinate now, don’t put it off.","Ellen DeGeneres",idCounter++));
        quoteOfTheDayList.add(new QuoteOfTheDay("I’m so unfamiliar with the gym, I call it James!","Ellen DeGeneres",idCounter++));
        quoteOfTheDayList.add(new QuoteOfTheDay("Reality continues to ruin my life.","Bill Watterson",idCounter++));

    }

    public void clearQuoteOfTheDay(){
        quoteOfTheDayList.clear();
    }
    public void addQuote(QuoteOfTheDay quote){
        quoteOfTheDayList.add(quote);
    }
    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus( value = HttpStatus.OK)
    public QuoteOfTheDay getQuoteOfTheDayList(){
        Random random = new Random();
        int randomIndex = random.nextInt(quoteOfTheDayList.size());
        return quoteOfTheDayList.get(randomIndex);
    }
}
