package com.jetbrains.ideatest2;

import java.util.Scanner;

public class GameController {


    public static Table askAndDetermineTableSize() {
        Scanner sc = new Scanner(System.in);
        int tableFieldsInput = 0;
        boolean validInput = false;
        do {
            System.out.println("Kérem a tábla mezőinek számát (8 és 30 között)! Az első mező a START mező.");
            tableFieldsInput = sc.nextInt();
            if (tableFieldsInput >= 8 && tableFieldsInput <=30) {
                validInput = true;
            } else {
                System.out.println("Ez így nem lesz jó!");
            }
        } while (!validInput);

        Table gameTable = new Table(4, tableFieldsInput * 4 + 1);

//        double columnsResult = Math.ceil(Math.sqrt((double) tableFieldsInput));
//        int rowsResult = (tableFieldsInput - (int) (2 * columnsResult)) / 2 + 2;
//        Table gameTable = new Table(2 * rowsResult + 1, (int) columnsResult * 4 + 1);

        return gameTable;
    }

    public static String askPlayerName() {
        Scanner sc = new Scanner(System.in);
        boolean validInput = false;
        String inputName = "";

        do {
            System.out.println("Kérem a Játékos nevét!");
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
            System.out.println("Válassz szimbólumot!");
            System.out.println("1 - " + Symbols.DOT.getSymbol() + "\n2 - " + Symbols.HASH.getSymbol());
            System.out.println("3 - " + Symbols.CROSS.getSymbol() + "\n4 - " + Symbols.CIRCLE.getSymbol());
            symbolNumberInput = sc.nextInt();
            if (symbolNumberInput == 1 || symbolNumberInput == 2 ||
                    symbolNumberInput == 3 || symbolNumberInput == 4) {
                validInput = true;
            }
        } while (!validInput);
        switch (symbolNumberInput) {
            case 1 : symbol = Symbols.DOT.getSymbol();
                break;
            case 2 : symbol = Symbols.HASH.getSymbol();
                break;
            case 3: symbol = Symbols.CROSS.getSymbol();
                break;
            case 4: symbol = Symbols.CIRCLE.getSymbol();
                break;
        }
        return symbol;
    }

}
