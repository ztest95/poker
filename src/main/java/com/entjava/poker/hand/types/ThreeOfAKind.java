package com.entjava.poker.hand.types;

import com.entjava.poker.card.Card;
import com.entjava.poker.hand.Hand;
import com.entjava.poker.hand.HandType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @see <a href="https://en.wikipedia.org/wiki/List_of_poker_hands#Three_of_a_kind">What is a Three of a Kind?</a>
 */
public class ThreeOfAKind extends Hand {

    private List<Card> threeOfAKindCards;
    private List<Card> otherCards;

    public ThreeOfAKind(List<Card> threeOfAKindCards, List<Card> otherCards) {
        this.threeOfAKindCards = threeOfAKindCards;
        this.otherCards = otherCards;
        Collections.sort(otherCards,Collections.reverseOrder());
        List<Card> threeOfAKindHand = new ArrayList<>();
        threeOfAKindHand.addAll(threeOfAKindCards);
        threeOfAKindHand.addAll(otherCards.subList(0,2));

        setCurrentHand(threeOfAKindHand);
    }

    public HandType getHandType() {
        return HandType.THREE_OF_A_KIND;
    }

    /**
     * @return The name of the hand plus kickers in descending rank, e.g. Trips (4) - A,2 High
     */
    @Override
    public String toString() {

        String kicker = otherCards.get(0).getRank().toString() + "," + otherCards.get(1).getRank().toString();
        return "Trips ("+threeOfAKindCards.get(0).getRank()+") - "+ kicker +" High";
    }

}
