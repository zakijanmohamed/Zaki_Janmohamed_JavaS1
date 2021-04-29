package com.GameStore.ZakiJanmohamedU1Capstone.dao;

import com.GameStore.ZakiJanmohamedU1Capstone.model.Console;

import java.util.List;

public interface ConsoleDao {

    Console addConsole (Console console);

    Console getConsole (int console_id);

    List<Console> getAllConsoles();

    void updateConsole (Console console);

    void deleteConsole(int console_id);

    List<Console> getConsoleByManufacturer(String manufacturer);
}
