package com.jetbrains.ideatest2;


import java.util.List;


public class Main {


    public static void main(String[] args) {

        Game newGame = new Game();
        newGame.gameDescription();
        Table gameTable = GameController.askAndDetermineTableSize();
        List<Player> list = Player.createPlayers();
        gameTable.printTable(list);
        QuestionsAndAnswers qAndA = new QuestionsAndAnswers();
        newGame.playGame(list, qAndA, gameTable);


    }
}
