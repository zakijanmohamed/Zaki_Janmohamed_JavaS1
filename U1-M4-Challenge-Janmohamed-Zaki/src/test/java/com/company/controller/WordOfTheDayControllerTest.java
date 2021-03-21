package com.company.controller;

import com.company.model.WordOfTheDay;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(WordOfTheDayController.class)
public class WordOfTheDayControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    WordOfTheDayController wordOfTheDayController;

    private ObjectMapper mapper = new ObjectMapper();

    private List<WordOfTheDay> wordOfTheDay;

    @Before
    public void setUp(){
        wordOfTheDay = new ArrayList<>();
        wordOfTheDay.add(new WordOfTheDay("random","something randomized i guess",1));
        wordOfTheDay.add(new WordOfTheDay("abcd","efghijk",2));

        wordOfTheDayController.clearWordOfTheDay();

        wordOfTheDay.stream()
                .forEach(c -> wordOfTheDayController.addWord(c));
    }

    @Test
    public void shouldReturnWordOfTheDay() throws Exception{
        String outputJson = mapper.writeValueAsString(wordOfTheDay);

        mockMvc.perform(get("/word"))
                .andDo(print())
                .andExpect(status().isOk());
             //   .andExpect(content().json(outputJson));


    }
}
