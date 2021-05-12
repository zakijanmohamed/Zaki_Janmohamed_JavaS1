package com.GameStore.ZakiJanmohamedU1Capstone.controller;

import com.GameStore.ZakiJanmohamedU1Capstone.model.Console;
import com.GameStore.ZakiJanmohamedU1Capstone.model.Game;
import com.GameStore.ZakiJanmohamedU1Capstone.service.InvoiceInventoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GameInventoryController.class)
public class GameInventoryControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private Game inputGame;
    private Game outputGame;

    @MockBean
    private InvoiceInventoryService serviceLayer;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
        setUpTestObject();
    }

    public void setUpTestObject(){

        inputGame = new Game();
        inputGame.setTitle("Grand Theft Auto V");
        inputGame.setEsrb_rating("M");
        inputGame.setDescription("Assume the role of 3 characters in a city called Los Santos");
        inputGame.setPrice(new BigDecimal("1.49"));
        inputGame.setStudio("Rockstar Games");
        inputGame.setQuantity(8);

        outputGame = new Game();
        outputGame.setGame_id(2);
        outputGame.setTitle("Need for Speed");
        outputGame.setEsrb_rating("T");
        outputGame.setDescription("Put your crocs into race car mode and go vroom vroom");
        outputGame.setPrice(new BigDecimal("1.49"));
        outputGame.setStudio("Slightly Mad Studio");
        outputGame.setQuantity(2);
    }

    @Test
    public void createGame() throws  Exception {
        String inputJsonString = mapper.writeValueAsString(inputGame);

        String outputJsonString = mapper.writeValueAsString(outputGame);

        when (serviceLayer.AddsGame(inputGame)).thenReturn(outputGame);

        this.mockMvc.perform(post("/game")
                .content(inputJsonString)
                .contentType(MediaType.APPLICATION_JSON)).
                andDo(print())
                .andExpect(status().isCreated())
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.content().json(outputJsonString));
    }

    @Test
    public void getGameById() throws  Exception {
        String outputJsonString = mapper.writeValueAsString(outputGame);
        mockMvc.perform(
                get("/game/{id}")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(outputJsonString));
    }

    @Test
    public void getAllGames() throws  Exception {

        Game outputGame1 = new Game();
        outputGame1.setGame_id(2);
        outputGame1.setTitle("Need for Speed");
        outputGame1.setEsrb_rating("T");
        outputGame1.setDescription("Put your crocs into race car mode and go vroom vroom");
        outputGame1.setPrice(new BigDecimal("1.49"));
        outputGame1.setStudio("Slightly Mad Studio");
        outputGame1.setQuantity(2);

        List<Game> gameList = new ArrayList<>();
        gameList.add(outputGame);
        gameList.add(outputGame1);
        String outputJsonString = mapper.writeValueAsString(gameList);
        when(serviceLayer.getAllGames()).thenReturn(gameList);
        mockMvc.perform(
                get("/game")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(outputJsonString));
    }

    @Test
    public void deleteGame() throws  Exception {
        Game game = new Game();
        game.setGame_id(1);
        mockMvc.perform(delete("/game/game_id/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void updateGame() throws  Exception {
        Game game = new Game();
        game.setGame_id(2);
        game.setTitle("Need for Speed");
        game.setEsrb_rating("T");
        game.setDescription("Put your crocs into race car mode and go vroom vroom");
        game.setPrice(new BigDecimal("1.49"));
        game.setStudio("Slightly Mad Studio");
        game.setQuantity(2);

        String inputJsonString = mapper.writeValueAsString(game);
        String outputJsonString =mapper.writeValueAsString(game);

        this.mockMvc.perform(put("game/{game_id}"+game.getGame_id())
                .content(inputJsonString)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());}
}