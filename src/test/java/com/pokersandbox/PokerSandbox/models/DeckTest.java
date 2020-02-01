package com.pokersandbox.PokerSandbox.models;

import com.pokersandbox.PokerSandbox.enums.Rank;
import com.pokersandbox.PokerSandbox.enums.Suit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class DeckTest {
    private Deck testDeck;
    private ArrayList<Card> testHand;

    @Before
    public void setup(){
        testDeck = Deck.getInstance();
        testHand = new ArrayList<>();
    }

    @Test
    public void generateTestTotalCount(){
        testDeck.generateDeck();
        Assert.assertEquals(52, testDeck.getDeck().size());
    }

    @Test
    public void generateTestUniqueCardsInDeck(){
        testDeck.generateDeck();
        int notExpected = 0;

        for(int i = 0; i<testDeck.getDeck().size(); i++){
            for(int j = 0; j<testDeck.getDeck().size(); j++){
                if(i != j){
                    Assert.assertNotEquals(notExpected, testDeck.getDeck().get(i).compareTo(testDeck.getDeck().get(j)));
            }
            }
        }
    }

    @Test
    public void burnCard1() {
        testDeck.generateDeck();
        int expectedBefore = 0;
        int beforeSize = testDeck.getMuck().size();

        Assert.assertEquals(expectedBefore, beforeSize);
    }

    @Test
    public void burnCard2() {
        testDeck.generateDeck();
        int expectedBefore = 1;

        //action
        testDeck.burnCard();

        int afterSize = testDeck.getMuck().size();

        Assert.assertEquals(expectedBefore, afterSize);
    }


    @Test
    public void removeCards() {
        testDeck.generateDeck();
        testHand.add(new Card(Suit.HEART, Rank.FIVE));

        int expected = 51;

        testDeck.removeCards(testHand);

        Assert.assertEquals(expected, this.testDeck.getDeck().size());
    }

    @Test
    public void removeCards1() {
        testDeck.generateDeck();
        testHand.add(new Card(Suit.HEART, Rank.FIVE));
        testHand.add(new Card(Suit.SPADE, Rank.ACE));

        int expected = 50;

        testDeck.removeCards(testHand);

        Assert.assertEquals(expected, this.testDeck.getDeck().size());
    }

    @Test
    public void removeCards2() {
        testDeck.generateDeck();
        testHand.add(new Card(Suit.HEART, Rank.FIVE));
        testHand.add(new Card(Suit.SPADE, Rank.ACE));
        testHand.add(new Card(Suit.DIAMOND, Rank.EIGHT));
        testHand.add(new Card(Suit.CLUBS, Rank.NINE));

        //action
        testDeck.removeCards(testHand);

        for (Card each: testHand) {
            Assert.assertFalse(testDeck.getDeck().contains(each));
        }

    }

    @Test
    public void getTopCard1() {
        testDeck.generateDeck();
        ArrayList<Card> card = (ArrayList<Card>)testDeck.getTopCard();

        int expected = 1;

        Assert.assertEquals(expected, card.size());
    }

    @Test
    public void getTopCard2() {
        testDeck.generateDeck();

        testDeck.getTopCard();

        //not 51 because we burn a card!
        int expected = 50;

        Assert.assertEquals(expected, testDeck.getDeck().size());
    }

    @Test
    public void getTopCard3MuckTest() {
        testDeck.generateDeck();
        testDeck.getTopCard();

        int expected = 1;

        Assert.assertEquals(expected, testDeck.getMuck().size());
    }

    @Test
    public void getFlop1() {
        testDeck.generateDeck();
        ArrayList<Card> card = (ArrayList<Card>)testDeck.getFlop();

        int expected = 3;

        Assert.assertEquals(expected, card.size());
    }

    @Test
    public void getFlop2() {
        testDeck.generateDeck();

        testDeck.getFlop();

        //not 51 because we burn a card!
        int expected = 48;

        Assert.assertEquals(expected, testDeck.getDeck().size());
    }

    @Test
    public void getFlop3MuckTest() {
        testDeck.generateDeck();
        testDeck.getFlop();

        int expected = 1;

        Assert.assertEquals(expected, testDeck.getMuck().size());
    }
}
