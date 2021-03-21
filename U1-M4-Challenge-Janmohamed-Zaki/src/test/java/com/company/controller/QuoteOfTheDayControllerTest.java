package com.company.controller;

import com.company.model.QuoteOfTheDay;
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

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(QuoteOfTheDayController.class)

public class QuoteOfTheDayControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    QuoteOfTheDayController quoteOfTheDayController;

    private ObjectMapper mapper = new ObjectMapper();

    private List<QuoteOfTheDay> quoteOfTheDay;

    @Before
    public void setUp() {
        quoteOfTheDay = new ArrayList<>();
        quoteOfTheDay.add(new QuoteOfTheDay("random", "something randomized i guess", 1));
        quoteOfTheDay.add(new QuoteOfTheDay("abcd", "efghijk", 2));

        quoteOfTheDayController.clearQuoteOfTheDay();

        quoteOfTheDay.stream()
                .forEach(c -> quoteOfTheDayController.addQuote(c));
    }

    @Test
    public void shouldReturnQuoteOfTheDay() throws Exception {
        String outputJson = mapper.writeValueAsString(quoteOfTheDay);

        mockMvc.perform(get("/quote"))
                .andDo(print())
                .andExpect(status().isOk());


    }
}