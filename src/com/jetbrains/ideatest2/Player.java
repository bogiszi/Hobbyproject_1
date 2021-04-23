package com.jetbrains.ideatest2;

import java.util.ArrayList;
import java.util.List;


public class Player {
    protected String name;
    protected int point;
    protected String symbol;

    public Player(String name, String symbol) {
        this.name = name;
        this.point = 0;
        this.symbol = symbol;
    }

    public static List<Player> createPlayers() {
        List<Player> playersList = new ArrayList<>();
        Player first = new Player(GameController.askPlayerName(), GameController.askPlayerSymbol());
        String secondName = GameController.askPlayerName();
        String secondSymbol = "";
        boolean validSymbol = false;
        do {
            secondSymbol = GameController.askPlayerSymbol();
            if (secondSymbol != first.symbol) {
                validSymbol = true;
            } else {
                System.out.println("Az a szimbólum már foglalt. Válassz másikat!");
            }
        } while (!validSymbol);
        Player second = new Player(secondName, secondSymbol);

        playersList.add(first);
        playersList.add(second);

        return playersList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
