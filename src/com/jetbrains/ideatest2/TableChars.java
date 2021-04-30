package com.jetbrains.ideatest2;

public enum TableChars {
    CORNER_BOTTOM_LEFT("┌"),
    CORNER_BOTTOM_RIGHT("┐"),
    CORNER_UPPER_LEFT("└"),
    CORNER_UPPER_RIGHT("┘"),
    LINE_HORIZONTAL("─"),
    LINE_VERTICAL("│"),
    BOTTOM_T("┴"),
    UPPER_T("┬");



    private String symbol;

    TableChars(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}

