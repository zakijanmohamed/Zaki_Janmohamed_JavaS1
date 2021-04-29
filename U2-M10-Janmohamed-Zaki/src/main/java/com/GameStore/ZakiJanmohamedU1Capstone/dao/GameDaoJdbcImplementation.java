package com.GameStore.ZakiJanmohamedU1Capstone.dao;

import com.GameStore.ZakiJanmohamedU1Capstone.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GameDaoJdbcImplementation implements GameDao{

    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_GAME_SQL =
            "insert into game (title, esrb_rating, description, price, studio, quantity) values (?, ?, ?, ?, ?, ?)";

    private static final String SELECT_GAME_SQL =
            "select * from game where game_id = ?";

    private static final String SELECT_ALL_GAMES_SQL =
            "select * from game";

    private static final String UPDATE_GAME_SQL =
            "update game set title = ?, esrb_rating = ?, description = ?, price = ?, studio = ? , quantity = ? where game_id = ?";

    private static final String DELETE_GAME =
            "delete from game where game_id = ?";

    private static final String SELECT_GAME_BY_STUDIO =
            "select * from game where studio = ? ";

    private static final String SELECT_GAME_BY_RATING =
            "select * from game where esrb_rating =? ";

    private static final String SELECT_GAME_BY_TITLE =
            "select * from game where title =? ";


    @Autowired
    public GameDaoJdbcImplementation(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Game addGame(Game game) {
        jdbcTemplate.update(INSERT_GAME_SQL,
        game.getTitle(),
        game.getEsrb_rating(),
        game.getDescription(),
        game.getPrice(),
        game.getStudio(),
        game.getQuantity());

        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        game.setGame_id(id);

        return game;
    }

    @Override
    public Game getGame(int game_id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_GAME_SQL, this::mapRowToGame, game_id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Game> getAllGame() {
        return jdbcTemplate.query(SELECT_ALL_GAMES_SQL, this::mapRowToGame);
    }

    @Override
    public void updateGame(Game game) {
        jdbcTemplate.update(UPDATE_GAME_SQL,
                game.getTitle(),
                game.getEsrb_rating(),
                game.getDescription(),
                game.getPrice(),
                game.getStudio(),
                game.getQuantity(),
                game.getGame_id());

    }

    @Override
    public void deleteGame(int game_id) {
        jdbcTemplate.update(DELETE_GAME, game_id);

    }

    @Override
    public List<Game> getGamesByStudio(String studio) {
        return jdbcTemplate.query(SELECT_GAME_BY_STUDIO, this::mapRowToGame, studio);
    }

    @Override
    public List<Game> getGamesByRating(String esrb_rating) {
        return jdbcTemplate.query(SELECT_GAME_BY_RATING, this::mapRowToGame, esrb_rating);
    }

    @Override
    public List<Game> getGamesByTitle(String title) {
        return jdbcTemplate.query(SELECT_GAME_BY_TITLE, this::mapRowToGame, title);
    }

    private Game mapRowToGame(ResultSet rs, int rowNum) throws SQLException {
        Game game = new Game();
        game.setGame_id(rs.getInt("game_id"));
        game.setTitle(rs.getString("title"));
        game.setEsrb_rating(rs.getString("esrb_rating"));
        game.setDescription(rs.getString("description"));
        game.setPrice(rs.getBigDecimal("price"));
        game.setStudio(rs.getString("studio"));
        game.setQuantity(rs.getInt("quantity"));

        return game;
    }
}
