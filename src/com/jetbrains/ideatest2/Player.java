package com.jetbrains.ideatest2;

import java.util.ArrayList;
import java.util.List;


public class Player {
    protected String name;
    protected int point;
    protected String symbol;
    private boolean isActualPlayer;
    private int actualDifficulty;

    public Player() {
    }

    public Player(String name, boolean isActualPlayer) {
        this.name = name;
        this.isActualPlayer = isActualPlayer;
        this.point = 0;
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

    public boolean isActualPlayer() {
        return isActualPlayer;
    }

    public void setActualPlayer(boolean actualPlayer) {
        isActualPlayer = actualPlayer;
    }

    public int getActualDifficulty() {
        return actualDifficulty;
    }

    public void setActualDifficulty(int actualDifficulty) {
        this.actualDifficulty = actualDifficulty;
    }
}
