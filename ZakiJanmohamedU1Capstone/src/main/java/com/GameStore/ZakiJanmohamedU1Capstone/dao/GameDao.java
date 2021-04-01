package com.GameStore.ZakiJanmohamedU1Capstone.dao;

import com.GameStore.ZakiJanmohamedU1Capstone.model.Game;

import java.util.List;

public interface GameDao {

    Game addGame(Game game); //

    Game getGame(int game_id);//

    List<Game> getAllGame();//

    void updateGame(Game game); //

    void deleteGame(int game_id);//

    List<Game> getGamesByStudio(String studio);

    List<Game> getGamesByRating(String esrb_rating);

    List<Game> getGamesByTitle(String title);


}
