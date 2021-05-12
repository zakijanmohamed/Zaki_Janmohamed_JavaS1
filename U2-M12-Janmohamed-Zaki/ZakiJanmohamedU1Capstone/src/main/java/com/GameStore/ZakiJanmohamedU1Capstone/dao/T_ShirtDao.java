package com.GameStore.ZakiJanmohamedU1Capstone.dao;

import com.GameStore.ZakiJanmohamedU1Capstone.model.T_Shirt;

import java.util.List;

public interface T_ShirtDao {

    T_Shirt addT_shirt(T_Shirt t_shirt);

    T_Shirt getT_shirt (int t_shirt_id);

    List<T_Shirt> getAllTshirts();

    void updateT_shirt(T_Shirt t_shirt);

    void deleteT_shirt(int t_shirt_id);

    List<T_Shirt> getTshirtByColor(String color);

    List<T_Shirt> getTshirtBySize(String size);



}
