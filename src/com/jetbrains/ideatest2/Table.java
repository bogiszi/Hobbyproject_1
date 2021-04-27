package com.jetbrains.ideatest2;

import java.util.List;

public class Table {

    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_BLACK = "\u001B[30m";
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_CYAN = "\u001B[36m";
    public static final String TEXT_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    protected int rows;
    protected int columns;
    protected String[][] board;


    public Table(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.board = new String[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }


    public void printTable(List<Player> playersList) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ((i == 0 || i == board.length - 1) && j % 4 != 0) {
                    board[i][j] = TableChars.LINE_HORIZONTAL.getSymbol();
                } else if ((i == 1 || i == 2) && j % 4 == 0) {
                    board[i][j] = TableChars.LINE_VERTICAL.getSymbol();
                } else if (i == 0 || i == rows - 3 && j % 4 == 0) {
                    board[i][j] = TableChars.UPPER_T.getSymbol();
                } else if (i == rows - 1 && j > 0 && j < columns - 1 && j % 4 == 0) {
                    board[i][j] = TableChars.BOTTOM_T.getSymbol();
                } else {
                    board[i][j] = " ";
                }
            }
        }
        board[0][0] = TableChars.CORNER_BOTTOM_LEFT.getSymbol();
        board[0][columns - 1] = TableChars.CORNER_BOTTOM_RIGHT.getSymbol();
        board[rows - 1][0] = TableChars.CORNER_UPPER_LEFT.getSymbol();
        board[rows - 1][columns - 1] = TableChars.CORNER_UPPER_RIGHT.getSymbol();
        for (Player player : playersList) {
            board[playersList.indexOf(player) + 1][2 + 4 * player.getPoint()] = player.getSymbol();
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(TEXT_BLACK + ANSI_BLUE_BACKGROUND + board[i][j] + TEXT_RESET);
            }
            System.out.println();

        }

    }
}
