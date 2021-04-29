package com.GameStore.ZakiJanmohamedU1Capstone.dao;

import com.GameStore.ZakiJanmohamedU1Capstone.model.Console;
import com.GameStore.ZakiJanmohamedU1Capstone.model.Game;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameDaoJdbcImplementationTest {

    @Autowired
    GameDao gameDao;

    private Game game;

    @Before
    public void setUp() throws Exception {
        clearDataBase();
        setUpTestObjects();
    }

    public void clearDataBase() {
        List<Game> games = gameDao.getAllGame();
        for (Game game : games) {
            gameDao.deleteGame(game.getGame_id());
        }
    }

    public void setUpTestObjects() {
        game = new Game();
        game.setTitle("Grand Theft Auto V");
        game.setEsrb_rating("M");
        game.setDescription("Assume the role of 3 characters in a city called Los Santos");
        game.setPrice(new BigDecimal("1.49"));
        game.setStudio("Rockstar Games");
        game.setQuantity(8);
    }

    @Test
    public void shouldAddGetDeleteGame() {
        game = gameDao.addGame(game);
        Game game1 = gameDao.getGame(game.getGame_id());
        assertEquals(game1, game);
        gameDao.deleteGame(game.getGame_id());
    }

    @Test
    public void shouldGetAllGames() {

        game = gameDao.addGame(game);

        game = new Game();
        game.setTitle("Grand Theft Auto VI");
        game.setEsrb_rating("M");
        game.setDescription("This game is still in production");
        game.setPrice(new BigDecimal("1.49"));
        game.setStudio("Rockstar Games");
        game.setQuantity(0);

        gameDao.addGame(game);

        List<Game> gameList = gameDao.getAllGame();
        assertEquals(2, gameList.size());
    }

    @Test
    public void shouldUpdateGame() {
        game = gameDao.addGame(game);

        game.setTitle("Grand Theft Auto VI");
        game.setEsrb_rating("M");
        game.setDescription("This game is still in production");
        game.setPrice(new BigDecimal("1.49"));
        game.setStudio("Rockstar Games");
        game.setQuantity(0);

        gameDao.updateGame(game);

        Game game1 = gameDao.getGame(game.getGame_id());
        assertEquals(game1, game);
    }

    @Test
    public void shouldGetGamesByStudio() {
        game = gameDao.addGame(game);

        Game game1 = new Game();
        game1.setTitle("Need for Speed");
        game1.setEsrb_rating("T");
        game1.setDescription("Put your crocs into race car mode and go vroom vroom");
        game1.setPrice(new BigDecimal("1.49"));
        game1.setStudio("Slightly Mad Studio");
        game1.setQuantity(0);

        gameDao.addGame(game1);

        List<Game> gameList = gameDao.getGamesByStudio(game.getStudio());
        assertEquals(1, gameList.size());

        List<Game> gameList1 = gameDao.getGamesByStudio(game1.getStudio());
        assertEquals(1, gameList1.size());

    }

    @Test
    public void shouldGetGamesByRating() {
        game = gameDao.addGame(game);

        Game game1 = new Game();
        game1.setTitle("Need for Speed");
        game1.setEsrb_rating("T");
        game1.setDescription("Put your crocs into race car more and go vroom vroom");
        game1.setPrice(new BigDecimal("1.49"));
        game1.setStudio("Slightly Mad Studio");
        game1.setQuantity(0);

        gameDao.addGame(game1);

        List<Game> gameList3 = gameDao.getGamesByRating(game.getEsrb_rating());
        assertEquals(1, gameList3.size());

        List<Game> gameList4 = gameDao.getGamesByRating(game1.getEsrb_rating());
        assertEquals(1, gameList4.size());
    }
    @Test
    public void shouldGetGamesByTitle() {
        game = gameDao.addGame(game);

        Game game1 = new Game();
        game1.setTitle("Need for Speed");
        game1.setEsrb_rating("T");
        game1.setDescription("Put your crocs into race car more and go vroom vroom");
        game1.setPrice(new BigDecimal("1.49"));
        game1.setStudio("Slightly Mad Studio");
        game1.setQuantity(0);

        gameDao.addGame(game1);

        List<Game> gameList = gameDao.getGamesByTitle(game.getTitle());
        assertEquals(1, gameList.size());

        List<Game> gameList1 = gameDao.getGamesByTitle(game1.getTitle());
        assertEquals(1, gameList1.size());

    }
}