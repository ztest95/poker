package com.entjava.poker.hand.types;

import com.entjava.poker.card.Card;
import com.entjava.poker.hand.Hand;
import com.entjava.poker.hand.HandType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @see <a href="https://en.wikipedia.org/wiki/List_of_poker_hands#One_pair">What is a One Pair?</a>
 */
public class OnePair extends Hand {

    private List<Card> pairCards;
    private List<Card> otherCards;

    public OnePair(List<Card> pairCards, List<Card> otherCards) {
        this.pairCards = pairCards;
        this.otherCards = otherCards;

        Collections.sort(otherCards,Collections.reverseOrder());

        List<Card> onePairHand = new ArrayList<>();
        onePairHand.addAll(pairCards);
        if(otherCards.size()!=0)
            onePairHand.addAll(otherCards.subList(0,3));

        setCurrentHand(onePairHand);

    }

    public HandType getHandType() {
        return HandType.ONE_PAIR;
    }

    /**
     * @return The name of the hand plus kickers ordered by descending rank, e.g. One Pair (2) - A,K,Q High,
     * or the name of the hand and rank if there are no community cards yet in play, e.g. One Pair (2)
     */
    @Override
    public String toString() {

        String highCards ="";
        if(otherCards.size()!=0)
            highCards = " - "+otherCards.get(0).getRank()+","
                            +otherCards.get(1).getRank()+","
                            +otherCards.get(2).getRank() + " High";

        return "One Pair ("+ pairCards.get(0).getRank()+")"+highCards;
    }

}
