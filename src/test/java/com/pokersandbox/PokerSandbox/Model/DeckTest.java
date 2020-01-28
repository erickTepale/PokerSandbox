package com.pokersandbox.PokerSandbox.Model;

import com.pokersandbox.PokerSandbox.Model.Card;
import com.pokersandbox.PokerSandbox.Model.Deck;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Set;

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
}
