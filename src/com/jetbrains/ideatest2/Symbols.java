package com.jetbrains.ideatest2;

public enum Symbols {
//    BLACK("▬"),
//    WHITE("▭"),


    DOT("@"),
    HASH("#"),
    CROSS("X"),
    CIRCLE("O");


    private String symbol;

    Symbols(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
