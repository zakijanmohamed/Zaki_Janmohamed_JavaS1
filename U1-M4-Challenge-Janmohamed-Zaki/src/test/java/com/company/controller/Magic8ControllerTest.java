package com.company.controller;

import com.company.model.Magic8;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(Magic8Controller.class)
public class Magic8ControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    Magic8Controller magicController;

    private ObjectMapper mapper = new ObjectMapper();

    private List<Magic8> question;
    //private Word words;

    @Before
    public void setUp() throws Exception {
        question = new ArrayList<>();

        question.add(new Magic8(1, "As I see it, yes."));
        question.add(new Magic8(2, "Ask again later."));
        question.add(new Magic8(3, "Better not tell you now."));
        question.add(new Magic8(4, "Concentrate and ask again."));
        question.add(new Magic8(5, "Don't count on it."));
        question.add(new Magic8(6, "It is decidedly so."));
        magicController.clearQ();

        question.stream()
                .forEach(c -> magicController.addA(c));

    }

    @Test
    public void shouldReturnQuestion() throws Exception {
        Magic8 inputQ = new Magic8();
        inputQ.setQuestion("What's Hi?");

        String inputJson = mapper.writeValueAsString(inputQ);

        Magic8 outputQ = new Magic8();
        outputQ.setQuestion("What's Hi?");

        String outputJson = mapper.writeValueAsString(outputQ);

        mockMvc.perform(
                post("/magic")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(String.valueOf(outputQ)));

    }
}


