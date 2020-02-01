package com.pokersandbox.PokerSandbox.Model;

import com.pokersandbox.PokerSandbox.enums.Rank;
import com.pokersandbox.PokerSandbox.enums.Suit;
import com.pokersandbox.PokerSandbox.models.Card;
import org.junit.Assert;
import org.junit.Test;

public class CardTest {

    @Test
    public void testCompareCardEqual(){
        Card card1 = new Card(Suit.HEART, Rank.ACE);
        Card card2 = new Card(Suit.HEART, Rank.ACE);

        int expected = 0;

        Assert.assertEquals(expected, card1.compareTo(card2));
    }

    @Test
    public void testCompareCardDiffSuit(){
        Card card1 = new Card(Suit.SPADE, Rank.ACE);
        Card card2 = new Card(Suit.HEART, Rank.ACE);

        int expected = 0;

        Assert.assertNotEquals(expected, card1.compareTo(card2));
    }

    @Test
    public void testCompareCardDiffRank(){
        Card card1 = new Card(Suit.HEART, Rank.KING);
        Card card2 = new Card(Suit.HEART, Rank.ACE);

        int expected = 0;

        Assert.assertNotEquals(expected, card1.compareTo(card2));
    }
}
