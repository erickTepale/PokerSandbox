package com.pokersandbox.PokerSandbox.enums;

public enum Suit {
    HEART("Hearts"),
    SPADE("Spade"),
    DIAMOND("Diamond"),
    CLUBS("Clubs");

    private final String suitText;

    Suit(String suitText){
        this.suitText = suitText;
    }

    public String getSuitText() {
        return suitText;
    }

    @Override
    public String toString() {
        return "of " + getSuitText();
    }
}




