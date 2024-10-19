package com.entjava.poker.hand;

import com.entjava.poker.card.Card;
import com.entjava.poker.card.CardRank;
import com.entjava.poker.card.CardSuit;
import com.entjava.poker.hand.types.FullHouse;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FullHouseTest {

    @Test
    public void toString_withFullHouse() {
        List<Card> trips = Arrays.asList(
                new Card(CardRank.FOUR, CardSuit.CLUBS),
                new Card(CardRank.FOUR, CardSuit.DIAMONDS),
                new Card(CardRank.FOUR, CardSuit.SPADES)
        );
        List<Card> pair = Arrays.asList(
                new Card(CardRank.ACE, CardSuit.CLUBS),
                new Card(CardRank.ACE, CardSuit.HEARTS)
        );

        FullHouse fullHouse = new FullHouse(trips, pair);

        assertEquals("Full House (4,A)", fullHouse.toString());
    }

}