package com.pokersandbox.PokerSandbox.enums;

public enum Rank {
        ACE(1,"A"), DEUCE(2, "Duece"), THREE(3, "Three"), FOUR(4, "Four"), FIVE(5, "Five"),
        SIX(6, "Six"), SEVEN(7, "Seven"), EIGHT(8, "Eight"), NINE(9, "Nine"), TEN(10, "Ten"),
        JACK(11, "J"), QUEEN(12, "Q"), KING(13, "K");

        private Integer rankValue;
        private String rankString;

        Rank(int rankValue, String rankString) {
            this.rankValue = rankValue;
            this.rankString = rankString;
        }

        public int getRankValue() {
            return rankValue;
        }

        public String getRankString() {
            return rankString;
        }


    @Override
    public String toString() {
        return getRankString();
    }
}
