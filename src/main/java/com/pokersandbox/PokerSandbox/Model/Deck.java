package com.pokersandbox.PokerSandbox.Model;

import java.util.List;
import java.util.Stack;

/**
 * Deck is singleton because we are going to be modifying deck as we go.
 * */
public class Deck {
    private static final Deck DECK_INSTANCE = new Deck();
    private Stack<Card> deck;
    private Stack<Card> muck;

    /**
     * @Info: Generates one deck with all 52 cards. Will be used to simulate game.
     * */
    private Deck() {
        this.muck = new Stack<>();
        generateDeck();
    }

    /**
     * @INFO: Generate a deck that will be used by the deck class.
     * */
    protected void generateDeck(){
        this.deck = new Stack<>();
        for(Suit suit: Suit.values()) {
            for(Rank rank: Rank.values()){
                this.deck.push(new Card(suit, rank));
            }
        }
    }

    /**
     * @Param: Cards that we know are already out such as Hole Cards, exposed cards, villain cards.
     * @TODO: Accept cards and remove them from deck
     * */
    public void removeCards(List<Card> cards){

    }

    /**
     * @Info: Simulates Turn and River. Burns card then returns a card
     * */
    public List<Card> getTopCard(){
        return null;
    }

    /**
     * @Info: Simulates Flop. Burns card then returns 3 cards
     * */
    public List<Card> getFlop(){
        return null;
    }

    /**
     * @Info: Moves a card from the top of the deck streight to the muck to simulate burning a card.
     *        This happens
     *          Once before Flop.
     *          Once before Turn.
     *          Once before River.
     *
     * @TODO: Pop one card from deck and move it into muck. Must throw exception if deck empty
     * */
    private void burnCard(){

    }

    /**
     * @INFO: Protected to be used in tests only
     * */
    protected List<Card> getDeck(){
        return this.deck;
    }

    /**
     * @INFO: Protected to be used in tests only
     * */
    protected void setDeck(List<Card> deck){
        this.deck = (Stack<Card>)deck;
    }

    /**
     * @INFO: Protected to be used in tests only
     * */
    protected List<Card> getMuck(){
        return this.muck;
    }

    /**
     * @INFO: Protected to be used in tests only
     * */
    protected void setMuck(List<Card> muck){
        this.muck = (Stack<Card>)muck;
    }

    public static Deck getInstance(){
        return DECK_INSTANCE;
    }


}
