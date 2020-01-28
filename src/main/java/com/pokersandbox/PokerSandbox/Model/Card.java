package com.pokersandbox.PokerSandbox.Model;

public class Card implements Comparable<Card>{
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return this.rank.getRankValue() + this.suit.getSuitText();
    }

    @Override
    public int compareTo(Card card) {
        int numCompare = Integer.compare(this.rank.getRankValue(), card.rank.getRankValue());
        int suitCompare = this.getSuit().getSuitText().compareTo(card.getSuit().getSuitText());
        if (numCompare != 0) {
            return numCompare;
        }
        return suitCompare;
    }
}
