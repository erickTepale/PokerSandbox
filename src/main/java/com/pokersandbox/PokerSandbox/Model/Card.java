package com.pokersandbox.PokerSandbox.Model;

import com.pokersandbox.PokerSandbox.Enum.Rank;
import com.pokersandbox.PokerSandbox.Enum.Suit;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suit == card.suit &&
                rank == card.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }
}
