package com.entjava.poker.hand;

import com.entjava.poker.card.Card;
import com.entjava.poker.card.CardRank;
import com.entjava.poker.card.CardSuit;
import com.entjava.poker.hand.types.ThreeOfAKind;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ThreeOfAKindTest {

    @Test
    public void toString_withTripFoursAndKickers() {
        List<Card> trips = Arrays.asList(
                new Card(CardRank.FOUR, CardSuit.CLUBS),
                new Card(CardRank.FOUR, CardSuit.DIAMONDS),
                new Card(CardRank.FOUR, CardSuit.SPADES)
        );
        List<Card> kickers = Arrays.asList(
                new Card(CardRank.ACE, CardSuit.CLUBS),
                new Card(CardRank.TWO, CardSuit.CLUBS)
        );

        ThreeOfAKind threeOfAKind = new ThreeOfAKind(trips, kickers);

        assertEquals("Trips (4) - A,2 High", threeOfAKind.toString());
    }

}