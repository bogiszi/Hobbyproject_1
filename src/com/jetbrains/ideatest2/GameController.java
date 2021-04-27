package com.jetbrains.ideatest2;

import java.util.Scanner;

public class GameController {

    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_BLACK = "\u001B[30m";
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_CYAN = "\u001B[36m";
    public static final String TEXT_WHITE = "\u001B[37m";


    public static Table askAndDetermineTableSize() {
        Scanner sc = new Scanner(System.in);
        int tableFieldsInput = 0;
        boolean validInput = false;
        do {
            System.out.println(TEXT_YELLOW +
                    "Kérem a tábla mezőinek számát (8 és 30 között)! Az első mező a START mező." + TEXT_RESET);
            tableFieldsInput = sc.nextInt();
            if (tableFieldsInput >= 8 && tableFieldsInput <= 30) {
                validInput = true;
            } else {
                System.out.println(TEXT_YELLOW + "Ez így nem lesz jó!" + TEXT_RESET);
            }
        } while (!validInput);

        Table gameTable = new Table(4, tableFieldsInput * 4 + 1);


        return gameTable;
    }

    public static String askPlayerName() {
        Scanner sc = new Scanner(System.in);
        boolean validInput = false;
        String inputName = "";

        do {
            System.out.println(TEXT_YELLOW + "Kérem a Játékos nevét!" + TEXT_RESET);
            inputName = sc.nextLine();
            if (inputName != null && inputName != "") {
                validInput = true;
            }
        } while (!validInput);

        return inputName;
    }

    public static String askPlayerSymbol() {
        Scanner sc = new Scanner(System.in);
        boolean validInput = false;
        int symbolNumberInput = 0;
        String symbol = "";

        do {
            System.out.println(TEXT_YELLOW +"Válassz szimbólumot!"+TEXT_RESET);
            System.out.println(TEXT_YELLOW +"1 - " + Symbols.DOT.getSymbol() +
                    "\n2 - " + Symbols.HASH.getSymbol()+TEXT_RESET);
            System.out.println(TEXT_YELLOW +"3 - " + Symbols.CROSS.getSymbol() +
                    "\n4 - " + Symbols.CIRCLE.getSymbol()+TEXT_RESET);
            symbolNumberInput = sc.nextInt();
            if (symbolNumberInput == 1 || symbolNumberInput == 2 ||
                    symbolNumberInput == 3 || symbolNumberInput == 4) {
                validInput = true;
            }
        } while (!validInput);
        switch (symbolNumberInput) {
            case 1:
                symbol = Symbols.DOT.getSymbol();
                break;
            case 2:
                symbol = Symbols.HASH.getSymbol();
                break;
            case 3:
                symbol = Symbols.CROSS.getSymbol();
                break;
            case 4:
                symbol = Symbols.CIRCLE.getSymbol();
                break;
        }
        return symbol;
    }

}
