package com.jetbrains.ideatest2;

import java.util.List;

public class Table {

    protected int rows;
    protected int columns;
    protected String[][] board;
    private boolean isStart;


    public Table(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.board = new String[rows][columns];
        this.isStart = true;
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

    public boolean isStart() {
        return isStart;
    }

    public void setStart(boolean start) {
        isStart = start;
    }

    public String printTable(List<Player> playersList) {
        String table = "";
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
                table += board[i][j];
            }
            table += "\n";

        }
        return table;
    }
}
