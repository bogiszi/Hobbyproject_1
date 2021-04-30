package com.jetbrains.ideatest2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import com.sun.javafx.tk.Toolkit;
import com.sun.javafx.tk.FontMetrics;

import java.awt.*;
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
        VBox root = new VBox(5);
        Label gameRules1 = new Label("Döntsétek el, milyen nehézségű kérdést szeretnétek kapni (1-3).");
        Label gameRules2 = new Label("Ha jól válaszoltok, annyi mezőt léphettek előre a táblán.");
        Label gameRules3 = new Label("Az nyer, aki először végigér a 15 mezős játéktáblán. Hajrá!");
        gameRules1.setStyle("-fx-font-size: 20px;");
        gameRules2.setStyle("-fx-font-size: 20px;");
        gameRules3.setStyle("-fx-font-size: 20px;");
        Button okButton = new Button("OK");
        okButton.setPrefSize(60, 40);
        root.getChildren().addAll(gameRules1, gameRules2, gameRules3, okButton);
        root.setAlignment(Pos.CENTER);
        Player first = new Player("1", true);
        Player second = new Player("2", false);
        players.add(first);
        players.add(second);
        okButton.setOnAction(t -> stage.setScene(askSymbolSceneFirstPlayer()));

        return new Scene(root, 800, 400);
    }

    public Scene askSymbolSceneFirstPlayer() {
        VBox root = new VBox(5);
        Label symbolText = new Label("Add meg a neved és válassz szimbólumot!");
        symbolText.setStyle("-fx-font-size: 20px;");
        Label playerText = new Label(players.get(0).getName() + ". játékos:");
        playerText.setStyle("-fx-font-size: 20px;");
        TextField userField = new TextField();
        userField.setMaxWidth(150);
        Button okButton = new Button("OK");
        okButton.setPrefSize(60, 40);
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
        root.setAlignment(Pos.CENTER);
        return new Scene(root, 400, 300);
    }

    public Scene askSymbolSceneSecondPlayer(List<RadioButton> buttons) {
        VBox root = new VBox(5);
        Label symbolText = new Label("Add meg a neved és válassz szimbólumot!");
        Label playerText = new Label(players.get(1).getName() + ". játékos:");
        playerText.setStyle("-fx-font-size: 20px;");
        playerText.setStyle("-fx-font-size: 20px;");
        TextField userField = new TextField();
        userField.setMaxWidth(150);
        Button okButton = new Button("OK");
        okButton.setPrefSize(60, 40);
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
        root.setAlignment(Pos.CENTER);
        return new Scene(root, 400, 300);
    }


    public Scene drawTableScene() {
        Table gameTable = new Table(4, 61);
        Label text = new Label("Aktuális állás:");
        text.setFont(Font.font(java.awt.Font.MONOSPACED, 20));
        text.setStyle("-fx-font-size: 20px;");
        Label table = new Label(gameTable.printTable(players));
        table.setFont(Font.font(java.awt.Font.MONOSPACED, 30));
        Button okButton;
        VBox root = new VBox(5);

        if ((players.get(0).getSteps() == players.get(1).getSteps()) &&
                (players.get(0).getPoint() >= (gameTable.getColumns() - 5) / 4 &&
                players.get(1).getPoint() >= (gameTable.getColumns() - 5) / 4)) {
            okButton = new Button("Menjünk az eredményhirdetésre!");
            okButton.setPrefSize(200, 40);
            okButton.setOnAction(t -> stage.setScene(finalSceneEqual()));
        } else if (players.get(0).getPoint() >= (gameTable.getColumns() - 5) / 4 &&
                players.get(0).getSteps() == players.get(1).getSteps()) {
            okButton = new Button("Menjünk az eredményhirdetésre!");
            okButton.setPrefSize(200, 40);
            okButton.setOnAction(t -> stage.setScene(finalScene(players.get(0))));
        } else if (players.get(1).getPoint() >= (gameTable.getColumns() - 5) / 4 &&
                players.get(0).getSteps() == players.get(1).getSteps()) {
            okButton = new Button("Menjünk az eredményhirdetésre!");
            okButton.setPrefSize(200, 40);
            okButton.setOnAction(t -> stage.setScene(finalScene(players.get(1))));
        } else {
            if (players.get(0).isActualPlayer()) {
                okButton = new Button("Jöhet a kérdés!");
                okButton.setPrefSize(200, 40);
                okButton.setOnAction(t -> stage.setScene(askdifficulty(players.get(0))));
            } else {
                okButton = new Button("Jöhet a kérdés!");
                okButton.setPrefSize(200, 40);
                okButton.setOnAction(t -> stage.setScene(askdifficulty(players.get(1))));
            }
        }
        root.getChildren().addAll(text, table, okButton);
        root.setAlignment(Pos.CENTER);
        return new Scene(root, 1200, 500);
    }




    public Scene askdifficulty(Player actualPlayer) {
        VBox root = new VBox(5);
        Label text = new Label(actualPlayer.getName() + ", milyen nehéz kérdést szeretnél?");
        text.setStyle("-fx-font-size: 20px;");
        Button okButton = new Button("OK");
        okButton.setPrefSize(60, 40);
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
        root.setAlignment(Pos.CENTER);
        return new Scene(root, 400, 300);
    }

    public Scene quizQuestionScene(Player actualPlayer) {
        VBox root = new VBox(10);
        String[] questionAndAnswer = newGame.getQuestionAndAnswer(qAndA, actualPlayer.getActualDifficulty());
        Label userLabel = new Label(questionAndAnswer[0]);
        userLabel.setStyle("-fx-font-size: 20px;");
        Button okButton = new Button("OK");
        okButton.setPrefSize(60, 40);
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
                    actualPlayer.setSteps(actualPlayer.getSteps() + 1);
                    String answerAfterChecking = "";
                    if (radio1.isSelected()) {
                        okButton.setDisable(true);
                        if (radio1.getText().equals(questionAndAnswer[1])) {
                            answerAfterChecking += "Szuper vagy!";
                            actualPlayer.setPoint(actualPlayer.getPoint() + actualPlayer.getActualDifficulty());
                        } else {
                            answerAfterChecking += "Nem jó a válasz! A helyes válasz: " + questionAndAnswer[1];
                        }
                    }
                    if (radio2.isSelected()) {
                        okButton.setDisable(true);
                        if (radio2.getText().equals(questionAndAnswer[1])) {
                            answerAfterChecking += "Szuper vagy!";
                            actualPlayer.setPoint(actualPlayer.getPoint() + actualPlayer.getActualDifficulty());
                        } else {
                            answerAfterChecking += "Nem jó a válasz! A helyes válasz: " + questionAndAnswer[1];
                        }
                    }
                    if (radio3.isSelected()) {
                        okButton.setDisable(true);
                        if (radio3.getText().equals(questionAndAnswer[1])) {
                            answerAfterChecking += "Szuper vagy!";
                            actualPlayer.setPoint(actualPlayer.getPoint() + actualPlayer.getActualDifficulty());
                        } else {
                            answerAfterChecking += "Nem jó a válasz! A helyes válasz: " + questionAndAnswer[1];
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
        root.setAlignment(Pos.CENTER);
        return new Scene(root, 600, 300);
    }

    public Scene responseScene(String input) {
        Label responseLabel = new Label(input);
        responseLabel.setStyle("-fx-font-size: 20px;");
        VBox root = new VBox(5);
        Button okButton = new Button("OK");
        okButton.setPrefSize(60, 40);
        root.getChildren().addAll(responseLabel, okButton);
        okButton.setOnAction(t -> stage.setScene(drawTableScene()));
        root.setAlignment(Pos.CENTER);
        return new Scene(root, 500, 300);
    }

    public Scene finalSceneEqual() {
        VBox root = new VBox(5);
        Label text = new Label("Döntetlen lett! Gratulálok!");
        text.setStyle("-fx-font-size: 20px;");
        Button okButton = new Button("OK");
        okButton.setPrefSize(60, 40);
        okButton.setOnAction(t -> stage.close());


        root.getChildren().addAll(text, okButton);
        root.setAlignment(Pos.CENTER);
        return new Scene(root, 400, 300);
    }

    public Scene finalScene(Player actualPlayer) {
        VBox root = new VBox(5);
        Label text = new Label(actualPlayer.getName() + " a nyertes! Gratulálok!");
        text.setStyle("-fx-font-size: 20px;");
        Button okButton = new Button("OK");
        okButton.setPrefSize(60, 40);
        okButton.setOnAction(t -> stage.close());


        root.getChildren().addAll(text, okButton);
        root.setAlignment(Pos.CENTER);
        return new Scene(root, 400, 300);

    }


    public static void main(String[] args) {
        launch(args);
    }


}
