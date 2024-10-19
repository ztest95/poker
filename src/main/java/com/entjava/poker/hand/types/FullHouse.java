package com.entjava.poker.hand.types;

import com.entjava.poker.card.Card;
import com.entjava.poker.hand.Hand;
import com.entjava.poker.hand.HandType;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://en.wikipedia.org/wiki/List_of_poker_hands#Full_house">What is a Full House?</a>
 */
public class FullHouse extends Hand {

    private List<Card> threeOfAKindCards;
    private List<Card> pairCards;

    public FullHouse(List<Card> threeOfAKindCards, List<Card> pairCards) {
        this.threeOfAKindCards = threeOfAKindCards;
        this.pairCards = pairCards;

        List<Card> fullHouseHand = new ArrayList<>();
        fullHouseHand.addAll(threeOfAKindCards);
        fullHouseHand.addAll(pairCards.subList(0,2));

        setCurrentHand(fullHouseHand);
    }

    public HandType getHandType() {
        return HandType.FULL_HOUSE;
    }

    /**
     * @return The name of the hand with rank of the three pair and two pair, e.g.
     * 444AA - Full House (4,A)
     */
    @Override
    public String toString() {
        String fullhouseString = threeOfAKindCards.get(0).getRank() + "," + pairCards.get(0).getRank();
        return "Full House ("+fullhouseString+")";
    }

}
