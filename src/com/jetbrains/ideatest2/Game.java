package com.jetbrains.ideatest2;



import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Game {


    public void gameDescription() {

        System.out.println("Döntsétek el, hány mezőből álljon a játéktábla\n" +
                "és válasszatok, milyen nehézségű kérdést szeretnétek kapni (1-3).\n" +
                "Ha jól válaszoltok, annyi mezőt léphettek előre a táblán." +
                " Az nyer, aki először végigér a játéktáblán. Hajrá!");
    }


    public void playGame(List<Player> players, QuestionsAndAnswers qAndA, Table gameTableInput) {
        Scanner sc = new Scanner(System.in);
        int playerIndex = 0;
        boolean isEnd = false;
        int countRound = 0;
        do {
            boolean validInput = false;
            int difficultyInput = 0;
            do {
                System.out.println(players.get(playerIndex).getName() + ", milyen nehéz kérdést szeretnél?");
                System.out.println("1 - könnyű\n2 - közepes\n3 - nehéz");
                difficultyInput = sc.nextInt();
                if (difficultyInput == 1 || difficultyInput == 2 || difficultyInput == 3) {
                    validInput = true;
                }
            } while (!validInput);
            String answer = "";
            for (Map.Entry<String, Integer> integerStringEntry : qAndA.getQuestionsAndAnswers().entrySet()) {
                if (integerStringEntry.getValue().equals(difficultyInput)) {
                    String[] questionAndAnswer = integerStringEntry.getKey().split(";");
                    System.out.println(questionAndAnswer[0]);
                    answer = questionAndAnswer[1];
                    qAndA.removeQuestionAndAnswer(integerStringEntry.getKey());
                    break;
                }
            }
            boolean isGoodAnswer = checkAnswer(answer);
            countRound++;
            if (isGoodAnswer) {
                players.get(playerIndex).setPoint(players.get(playerIndex).getPoint() + difficultyInput);
            }
            if (players.get(playerIndex).getPoint() * 4 + 2 >= gameTableInput.getColumns() - 3) {
                isEnd = true;
                players.get(playerIndex).setPoint(((gameTableInput.getColumns() - 5) / 4));
            }

            gameTableInput.printTable(players);

            if (playerIndex == 0) {
                playerIndex = 1;
            } else {
                playerIndex = 0;
            }
        } while (!isEnd || countRound % 2 != 0);
        checkAndDisplayWinnwer(players);
    }


    public static boolean checkAnswer(String inputAnswer) {
        Scanner sc = new Scanner(System.in);
        String playerAnswer = sc.nextLine();
        if (playerAnswer.equals(inputAnswer)) {
            System.out.println("Szuper vagy!");
            return true;
        } else {
            System.out.println("Nem jó a válasz.");
        }
        return false;
    }

    public static void checkAndDisplayWinnwer(List<Player> players) {
        if (players.get(0).getPoint() > players.get(1).getPoint()) {
            System.out.println(players.get(0).getName() + " nyert! Gratulálok!");
        } else if (players.get(1).getPoint() > players.get(0).getPoint()) {
            System.out.println(players.get(1).getName() + " nyert! Gratulálok!");
        } else {
            System.out.println("A végeredmény: döntetlen!");
        }
    }

}


