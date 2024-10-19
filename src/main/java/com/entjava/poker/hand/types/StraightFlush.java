package com.entjava.poker.hand.types;

import com.entjava.poker.card.Card;
import com.entjava.poker.card.CardRank;
import com.entjava.poker.hand.HandType;

import java.util.List;

/**
 * @see <a href="https://en.wikipedia.org/wiki/List_of_poker_hands#Straight_flush">What is a Straight Flush?</a>
 */
public class StraightFlush extends Straight {

    public StraightFlush(List<Card> cards) {
        super(cards);
        setCurrentHand(cards);
    }

    @Override
    public HandType getHandType() {
        return HandType.STRAIGHT_FLUSH;
    }

    /**
     * @return Royal Flush if the hand is a royal flush, or Straight Flush with the highest rank card,
     * e.g. Straight Flush (K High)
     */
    @Override
    public String toString() {

        if(getCards().get(0).getRank()== CardRank.ACE) return "Royal Flush";
        else return "Straight Flush (" + getCards().get(0).getRank()+" High)";

    }

}
