package com.entjava.poker.game;

import com.entjava.poker.deck.Deck;
import com.entjava.poker.deck.DeckBuilder;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeckBuilderTest {

	@Test
	public void buildDeck() {
		DeckBuilder deckBuilder = new DeckBuilder();

		Deck deck = deckBuilder.buildDeck();

		assertEquals(52, deck.size());
	}

}