package com.pokersandbox.PokerSandbox.models;

import com.pokersandbox.PokerSandbox.enums.Rank;
import com.pokersandbox.PokerSandbox.enums.Suit;

import java.util.*;

/**
 * Deck is singleton because we are going to be modifying deck as we go.
 * */
public class Deck {
    private static final Deck DECK_INSTANCE = new Deck();
    private Stack<Card> deck;
    private Stack<Card> muck;

    /**
     * INFO Generates one deck with all 52 cards. Will be used to simulate game.
     * */
    private Deck() {
        this.muck = new Stack<>();
        generateDeck();
    }

    /**
     * INFO: Generate a deck that will be used by the deck class.
     * */
    protected void generateDeck(){
        this.deck = new Stack<>();
        this.muck = new Stack<>();
        for(Suit suit: Suit.values()) {
            for(Rank rank: Rank.values()){
                this.deck.push(new Card(suit, rank));
            }
        }
    }

    /**
     * Param: Cards that we know are already out such as Hole Cards, exposed cards, villain cards.
     * TODO Accept cards and remove them from deck
     * */
    public void removeCards(List<Card> cards){
        for (Card each :cards) {
            this.deck.remove(each);
        }
    }

    /**
     * Info: Simulates Turn and River. Burns card then returns a card
     * */
    public List<Card> getTopCard(){
        burnCard();
        return new ArrayList<Card>(Arrays.asList(this.deck.pop()));
    }

    /**
     * Info: Simulates Flop. Burns card then returns 3 cards
     * */
    public List<Card> getFlop(){
        burnCard();
        return new ArrayList<Card>(Arrays.asList(this.deck.pop(),this.deck.pop(),this.deck.pop() ));
    }

    /**
     * Info: Moves a card from the top of the deck streight to the muck to simulate burning a card.
     *        This happens
     *          Once before Flop.
     *          Once before Turn.
     *          Once before River.
     *
     * TODO: Pop one card from deck and move it into muck. Must throw exception if deck empty
     * */
    protected void burnCard(){
        try {
            this.muck.push(this.deck.pop());
        }catch (EmptyStackException e){
            System.out.println("This should never happen doe, maybe log it?");
        }
    }

    /**
     * INFO: Protected to be used in tests only
     * */
    protected List<Card> getDeck(){
        return this.deck;
    }

    /**
     * INFO: Protected to be used in tests only
     * */
    protected void setDeck(List<Card> deck){
        this.deck = (Stack<Card>)deck;
    }

    /**
     * INFO: Protected to be used in tests only
     * */
    protected List<Card> getMuck(){
        return this.muck;
    }

    /**
     * INFO: Protected to be used in tests only
     * */
    protected void setMuck(List<Card> muck){
        this.muck = (Stack<Card>)muck;
    }

    public static Deck getInstance(){
        return DECK_INSTANCE;
    }


}
