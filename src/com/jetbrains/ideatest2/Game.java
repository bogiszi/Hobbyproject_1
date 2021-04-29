package com.jetbrains.ideatest2;


import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Game {


//    public void playGame(List<Player> players, QuestionsAndAnswers qAndA, Table gameTableInput) {
//        Scanner sc = new Scanner(System.in);
//        int playerIndex = 0;
//        boolean isEnd = false;
//        int countRound = 0;
//        do {
//            boolean validInput = false;
//            int difficultyInput = 0;
//            do {
//                System.out.println(GameController.TEXT_YELLOW + players.get(playerIndex).getName() +
//                        ", milyen nehéz kérdést szeretnél?" + GameController.TEXT_RESET);
//                System.out.println(GameController.TEXT_YELLOW + "1 - könnyű\n2 - közepes\n3 - nehéz" + GameController.TEXT_RESET);
//                difficultyInput = sc.nextInt();
//                if (difficultyInput == 1 || difficultyInput == 2 || difficultyInput == 3) {
//                    validInput = true;
//                }
//            } while (!validInput);
//            String[] answer = getQuestionAndSetAnswer(qAndA, difficultyInput);
//            boolean isGoodAnswer = checkAnswer(answer);
//            countRound++;
//            isEnd = checkAndSetPoint(players, gameTableInput, playerIndex, isEnd, difficultyInput, isGoodAnswer);
//            gameTableInput.printTable(players);
//            playerIndex = changePlayer(playerIndex);
//        } while (!isEnd || countRound % 2 != 0);
//        checkAndDisplayWinnwer(players);
//    }
//
    public String[] getQuestionAndAnswer(QuestionsAndAnswers qAndA, int difficultyInput) {
        String[] questionAndAnswer = new String[5];
        for (Map.Entry<String, Integer> integerStringEntry : qAndA.getQuestionsAndAnswers().entrySet()) {
            if (integerStringEntry.getValue().equals(difficultyInput)) {
                questionAndAnswer = integerStringEntry.getKey().split(";");
                qAndA.removeQuestionAndAnswer(integerStringEntry.getKey());
                break;
            }
        }
        return questionAndAnswer;
    }
//
//    private boolean checkAndSetPoint(List<Player> players, Table gameTableInput, int playerIndex, boolean isEnd, int difficultyInput, boolean isGoodAnswer) {
//        if (isGoodAnswer) {
//            players.get(playerIndex).setPoint(players.get(playerIndex).getPoint() + difficultyInput);
//        }
//        if (players.get(playerIndex).getPoint() * 4 + 2 >= gameTableInput.getColumns() - 3) {
//            isEnd = true;
//            players.get(playerIndex).setPoint(((gameTableInput.getColumns() - 5) / 4));
//        }
//        return isEnd;
//    }
//
//    private int changePlayer(int playerIndex) {
//        if (playerIndex == 0) {
//            playerIndex = 1;
//        } else {
//            playerIndex = 0;
//        }
//        return playerIndex;
//    }
//
//
//    public static boolean checkAnswer(String[] inputAnswers) {
//        Scanner sc = new Scanner(System.in);
//        char playerAnswer = sc.nextLine().charAt(0);
//        if (playerAnswer == inputAnswers[1].charAt(0)) {
//            System.out.println(GameController.TEXT_CYAN + "Szuper vagy!" + GameController.TEXT_RESET);
//            return true;
//        } else {
//            System.out.println(GameController.TEXT_RED + "Nem jó a válasz.\nA helyes válasz: " +
//                    inputAnswers[0] + GameController.TEXT_RESET);
//        }
//        return false;
//    }
//
//    public static void checkAndDisplayWinnwer(List<Player> players) {
//        if (players.get(0).getPoint() > players.get(1).getPoint()) {
//            System.out.println(GameController.TEXT_PURPLE + players.get(0).getName() +
//                    " nyert! Gratulálok!" + GameController.TEXT_RESET);
//        } else if (players.get(1).getPoint() > players.get(0).getPoint()) {
//            System.out.println(GameController.TEXT_PURPLE + players.get(1).getName() +
//                    " nyert! Gratulálok!" + GameController.TEXT_RESET);
//        } else {
//            System.out.println(GameController.TEXT_PURPLE + "A végeredmény: döntetlen!" + GameController.TEXT_RESET);
//        }
//    }
//
//}
}

