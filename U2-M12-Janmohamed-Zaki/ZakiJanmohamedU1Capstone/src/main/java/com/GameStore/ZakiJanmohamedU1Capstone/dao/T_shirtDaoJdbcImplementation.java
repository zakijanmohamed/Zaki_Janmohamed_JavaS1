package com.GameStore.ZakiJanmohamedU1Capstone.dao;

import com.GameStore.ZakiJanmohamedU1Capstone.model.T_Shirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class T_shirtDaoJdbcImplementation implements T_ShirtDao {

    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_T_SHIRT_SQL =
            "insert into t_shirt (size, color, description, price, quantity) values (?, ?, ?, ?, ?)";

    private static final String SELECT_T_SHIRT_SQL =
            "select * from t_shirt where t_shirt_id = ?";

    private static final String SELECT_ALL_T_SHIRTS_SQL =
            "select * from t_shirt";

    private static final String UPDATE_T_SHIRT_SQL =
            "update t_shirt set size = ?, color = ?, description = ?, price = ?, quantity = ? where t_shirt_id = ?";

    private static final String DELETE_T_SHIRT =
            "delete from t_shirt where t_shirt_id = ?";

    private static final String SELECT_T_SHIRT_BY_COLOR =
            "select * from t_shirt where color =? ";

    private static final String SELECT_SHIRT_BY_SIZE =
            "select * from t_shirt where size = ?";

    @Autowired
    public T_shirtDaoJdbcImplementation(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public T_Shirt addT_shirt(T_Shirt t_shirt) {
        jdbcTemplate.update(INSERT_T_SHIRT_SQL,
                t_shirt.getSize(),
                t_shirt.getColor(),
                t_shirt.getDescription(),
                t_shirt.getPrice(),
                t_shirt.getQuantity());

        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        t_shirt.setT_shirt_id(id);

        return t_shirt;
    }

    @Override
    public T_Shirt getT_shirt(int t_shirt_id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_T_SHIRT_SQL, this::mapRowToTee, t_shirt_id);
        } catch (EmptyResultDataAccessException e) {
            return null; }
    }

    @Override
    public List<T_Shirt> getAllTshirts() {
        return jdbcTemplate.query(SELECT_ALL_T_SHIRTS_SQL, this::mapRowToTee);
    }

    @Override
    public void updateT_shirt(T_Shirt t_shirt) {
        jdbcTemplate.update(UPDATE_T_SHIRT_SQL,
                t_shirt.getSize(),
                t_shirt.getColor(),
                t_shirt.getDescription(),
                t_shirt.getPrice(),
                t_shirt.getQuantity(),
                t_shirt.getT_shirt_id());
    }

    @Override
    public void deleteT_shirt(int t_shirt_id) {
        jdbcTemplate.update(DELETE_T_SHIRT,t_shirt_id);

    }

    @Override
    public List<T_Shirt> getTshirtByColor(String color) {
        return jdbcTemplate.query(SELECT_T_SHIRT_BY_COLOR, this::mapRowToTee, color);
    }

    @Override
    public List<T_Shirt> getTshirtBySize(String size) {
        return jdbcTemplate.query(SELECT_SHIRT_BY_SIZE, this::mapRowToTee, size);
    }

    private T_Shirt mapRowToTee(ResultSet rs, int rowNum) throws SQLException {
        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setT_shirt_id(rs.getInt("t_shirt_id"));
        t_shirt.setSize(rs.getString("size"));
        t_shirt.setColor(rs.getString("color"));
        t_shirt.setDescription(rs.getString("description"));
        t_shirt.setPrice(rs.getBigDecimal("price"));
        t_shirt.setQuantity(rs.getInt("quantity"));

        return t_shirt;
    }
}
