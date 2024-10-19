package com.entjava.poker.hand.types;

import com.entjava.poker.card.Card;
import com.entjava.poker.hand.Hand;
import com.entjava.poker.hand.HandType;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @see <a href="https://en.wikipedia.org/wiki/List_of_poker_hands#High_card">What is a High Card?</a>
 */
public class HighCard extends Hand {

    private List<Card> cards;

    public HighCard(List<Card> cards) {
        this.cards = cards;
        this.cards.sort(Collections.reverseOrder());
        if(cards.size()==2)
            setCurrentHand(cards.subList(0,2));
        else
            setCurrentHand(cards.subList(0,5));
    }

    public HandType getHandType() {
        return HandType.HIGH_CARD;
    }

    /**
     * @return The cards ordered by descending rank, e.g. A,K,Q,3,2
     */
    @Override
    public String toString() {

        int cardCount = 5;
        if(cards.size()==2)
            cardCount=2;

        List<String> cardsString = cards.subList(0,cardCount).stream().map((Card card) -> card.getRank().toString()).collect(Collectors.toList());
        return cardsString.stream().collect(Collectors.joining(","));
    }
}
