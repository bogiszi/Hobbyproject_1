package com.jetbrains.ideatest2;


import java.util.Map;

public class Game {


    public String[] getQuestionAndAnswer(QuestionsAndAnswers qAndA, int difficultyInput) {
        if (qAndA.getQuestionsAndAnswers().size() == 0) {
            qAndA = new QuestionsAndAnswers();
        }
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

