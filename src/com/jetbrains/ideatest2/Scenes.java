package com.jetbrains.ideatest2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;


public class Scenes extends Application {

    private Stage stage;
    private List<Player> players = new ArrayList<>();
    Game newGame = new Game();
    QuestionsAndAnswers qAndA = new QuestionsAndAnswers();


    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        Scene scene = firstScene();
        stage.setTitle("KVÍZJÁTÉK");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Scene firstScene() {
        Pane root = new Pane();
        Label gameRules = new Label("Döntsétek el, hány mezőből álljon a játéktábla és válasszatok, " +
                "milyen nehézségű kérdést szeretnétek kapni (1-3). Ha jól válaszoltok, annyi mezőt léphettek előre a táblán." +
                "Az nyer, aki először végigér a játéktáblán. Hajrá!");
        Button okButton = new Button("OK");
        VBox vbox = new VBox(5);
        vbox.getChildren().addAll(gameRules, okButton);
        Player first = new Player("1", true);
        Player second = new Player("2", false);
        players.add(first);
        players.add(second);
        okButton.setOnAction(t -> stage.setScene(askSymbolSceneFirstPlayer()));
        root.getChildren().addAll(vbox);
        return new Scene(root);
    }

    public Scene askSymbolSceneFirstPlayer() {
        VBox root = new VBox(5);
        Label symbolText = new Label("Add meg a neved és válassz szimbólumot!");
        Label playerText = new Label(players.get(0).getName() + ". játékos:");
        TextField userField = new TextField();
        Button okButton = new Button("OK");
        RadioButton radio1, radio2, radio3, radio4;
        radio1 = new RadioButton("@");
        radio2 = new RadioButton("X");
        radio3 = new RadioButton("O");
        radio4 = new RadioButton("#");
        List<RadioButton> radioButtons = new ArrayList<>();
        radioButtons.add(radio1);
        radioButtons.add(radio2);
        radioButtons.add(radio3);
        radioButtons.add(radio4);

        okButton.setDisable(true);

        radio1.setOnAction(e -> okButton.setDisable(false));
        radio2.setOnAction(e -> okButton.setDisable(false));
        radio3.setOnAction(e -> okButton.setDisable(false));
        radio4.setOnAction(e -> okButton.setDisable(false));

        okButton.setOnAction(e ->
                {
                    players.get(0).setName(userField.getText());
                    if (radio1.isSelected()) {
                        players.get(0).setSymbol("@");
                        radioButtons.remove(radio1);
                        okButton.setDisable(true);
                    }
                    if (radio2.isSelected()) {
                        players.get(0).setSymbol("X");
                        radioButtons.remove(radio2);
                        okButton.setDisable(true);
                    }
                    if (radio3.isSelected()) {
                        players.get(0).setSymbol("O");
                        radioButtons.remove(radio3);
                        okButton.setDisable(true);
                    }
                    if (radio4.isSelected()) {
                        players.get(0).setSymbol("#");
                        radioButtons.remove(radio4);
                        okButton.setDisable(true);
                    }
                    stage.setScene(askSymbolSceneSecondPlayer(radioButtons));
                }
        );
        root.getChildren().addAll(symbolText, playerText, userField, radio1, radio2, radio3, radio4, okButton);
        return new Scene(root);
    }

    public Scene askSymbolSceneSecondPlayer(List<RadioButton> buttons) {
        VBox root = new VBox(5);
        Label symbolText = new Label("Add meg a neved és válassz szimbólumot!");
        Label playerText = new Label(players.get(1).getName() + ". játékos:");
        TextField userField = new TextField();
        Button okButton = new Button("OK");
        RadioButton radio1, radio2, radio3;
        radio1 = buttons.get(0);
        radio2 = buttons.get(1);
        radio3 = buttons.get(2);

        okButton.setDisable(true);

        radio1.setOnAction(e -> okButton.setDisable(false));
        radio2.setOnAction(e -> okButton.setDisable(false));
        radio3.setOnAction(e -> okButton.setDisable(false));

        okButton.setOnAction(e ->
                {
                    players.get(1).setName(userField.getText());
                    if (radio1.isSelected()) {
                        players.get(1).setSymbol(radio1.getText());
                        okButton.setDisable(true);
                    }
                    if (radio2.isSelected()) {
                        players.get(1).setSymbol(radio2.getText());
                        okButton.setDisable(true);
                    }
                    if (radio3.isSelected()) {
                        players.get(1).setSymbol(radio3.getText());
                        okButton.setDisable(true);
                    }

                    stage.setScene(drawTableScene());
                }
        );
        root.getChildren().addAll(symbolText, playerText, userField, radio1, radio2, radio3, okButton);
        return new Scene(root);
    }


    public Scene drawTableScene() {
        Table gameTable = new Table(4, 61);
        Pane root = new Pane();
        Label text = new Label("Aktuális állás:");
        Label table = new Label(gameTable.printTable(players));
        Button okButton = new Button("Jöhet a kérdés!");
        VBox vbox = new VBox(5);
        vbox.getChildren().addAll(text, table, okButton);
        if (players.get(0).isActualPlayer()) {
            okButton.setOnAction(t -> stage.setScene(askdifficulty(players.get(0))));
        } else {
            okButton.setOnAction(t -> stage.setScene(askdifficulty(players.get(1))));
        }
        root.getChildren().addAll(vbox);
        return new Scene(root);
    }

    public Scene askdifficulty(Player actualPlayer) {
        VBox root = new VBox(5);
        Label text = new Label(actualPlayer.getName() + ", milyen nehéz kérdést szeretnél?");
        Button okButton = new Button("OK");
        RadioButton radio1, radio2, radio3;
        radio1 = new RadioButton("1");
        radio2 = new RadioButton("2");
        radio3 = new RadioButton("3");

        okButton.setDisable(true);

        radio1.setOnAction(e -> okButton.setDisable(false));
        radio2.setOnAction(e -> okButton.setDisable(false));
        radio3.setOnAction(e -> okButton.setDisable(false));

        okButton.setOnAction(e ->
                {
                    if (radio1.isSelected()) {
                        actualPlayer.setActualDifficulty(1);
                        okButton.setDisable(true);
                    }
                    if (radio2.isSelected()) {
                        actualPlayer.setActualDifficulty(2);
                        okButton.setDisable(true);
                    }
                    if (radio3.isSelected()) {
                        actualPlayer.setActualDifficulty(3);
                        okButton.setDisable(true);
                    }
                    stage.setScene(quizQuestionScene(actualPlayer));
                }
        );
        root.getChildren().addAll(text, radio1, radio2, radio3, okButton);
        return new Scene(root);
    }

    public Scene quizQuestionScene(Player actualPlayer) {
        VBox root = new VBox(10);
        String[] questionAndAnswer = newGame.getQuestionAndAnswer(qAndA, actualPlayer.getActualDifficulty());
        Label userLabel = new Label(questionAndAnswer[0]);
                Button okButton = new Button("OK");
        RadioButton radio1, radio2, radio3;
        radio1 = new RadioButton(questionAndAnswer[2]);
        radio2 = new RadioButton(questionAndAnswer[3]);
        radio3 = new RadioButton(questionAndAnswer[4]);
        ToggleGroup question1 = new ToggleGroup();

        radio1.setToggleGroup(question1);
        radio2.setToggleGroup(question1);
        radio3.setToggleGroup(question1);

        okButton.setDisable(true);

        radio1.setOnAction(e -> okButton.setDisable(false));
        radio2.setOnAction(e -> okButton.setDisable(false));
        radio3.setOnAction(e -> okButton.setDisable(false));


        okButton.setOnAction(e ->
                {
                    String answerAfterChecking = "";
                    if (radio1.isSelected()) {
                        okButton.setDisable(true);
                        if (radio1.getText().equals(questionAndAnswer[1])) {
                            answerAfterChecking += "Szuper vagy!";
                            actualPlayer.setPoint(actualPlayer.getPoint() + actualPlayer.getActualDifficulty());
                        } else {
                            answerAfterChecking +="Nem jó a válasz! A helyes válasz: " + questionAndAnswer[1];
                        }
                    }
                    if (radio2.isSelected()) {
                        okButton.setDisable(true);
                        if (radio2.getText().equals(questionAndAnswer[1])) {
                            answerAfterChecking += "Szuper vagy!";
                            actualPlayer.setPoint(actualPlayer.getPoint() + actualPlayer.getActualDifficulty());
                        } else {
                            answerAfterChecking +="Nem jó a válasz! A helyes válasz: " + questionAndAnswer[1];
                        }
                    }
                    if (radio3.isSelected()) {
                        okButton.setDisable(true);
                        if (radio3.getText().equals(questionAndAnswer[1])) {
                            answerAfterChecking += "Szuper vagy!";
                            actualPlayer.setPoint(actualPlayer.getPoint() + actualPlayer.getActualDifficulty());
                        } else {
                            answerAfterChecking +="Nem jó a válasz! A helyes válasz: " + questionAndAnswer[1];
                        }
                    }

                    for (Player player : players) {
                        if (player.isActualPlayer() == true) {
                            player.setActualPlayer(false);
                        } else {
                            player.setActualPlayer(true);
                        }
                    }
                    stage.setScene(responseScene(answerAfterChecking));
                }

        );

        root.getChildren().addAll(userLabel, radio1, radio2, radio3, okButton);
        return new Scene(root);
    }

    public Scene responseScene(String input) {
        Label labelresponse = new Label(input);
        VBox root = new VBox(5);
        Button okButton = new Button("OK");
        root.getChildren().addAll(labelresponse, okButton);
        okButton.setOnAction(t -> stage.setScene(drawTableScene()));
        return new Scene(root);
    }





    public static void main(String[] args) {


        launch(args);


//            newGame.playGame(list, qAndA, gameTable);


    }


}
