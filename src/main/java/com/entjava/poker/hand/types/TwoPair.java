package com.entjava.poker.hand.types;

import com.entjava.poker.card.Card;
import com.entjava.poker.hand.Hand;
import com.entjava.poker.hand.HandType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @see <a href="https://en.wikipedia.org/wiki/List_of_poker_hands#Two_pair">What is a Two Pair?</a>
 */
public class TwoPair extends Hand {

    private List<Card> firstPairCards;
    private List<Card> secondPairCards;
    private List<Card> otherCards;

    public TwoPair(List<Card> firstPairCards, List<Card> secondPairCards, List<Card> otherCards) {
        this.firstPairCards = firstPairCards;
        this.secondPairCards = secondPairCards;
        this.otherCards = otherCards;

        Collections.sort(otherCards,Collections.reverseOrder());
        List<Card> twoPairHand = new ArrayList<>();
        twoPairHand.addAll(firstPairCards);
        twoPairHand.addAll(secondPairCards);
        twoPairHand.add(otherCards.get(0));

        setCurrentHand(twoPairHand);
    }

    public HandType getHandType() {
        return HandType.TWO_PAIR;
    }

    /**
     * @return The name of the hand with kicker ranked in descending order, e.g. Two Pair (4,3) - A High
     */
    @Override
    public String toString() {
        return "Two Pair ("+firstPairCards.get(0).getRank()+","+secondPairCards.get(0).getRank()+") - "+otherCards.get(0).getRank()+" High";
    }

}
