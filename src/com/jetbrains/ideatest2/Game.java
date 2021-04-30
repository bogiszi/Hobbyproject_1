package com.jetbrains.ideatest2;


import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Game {


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

}

