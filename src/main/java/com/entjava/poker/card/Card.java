package com.entjava.poker.card;

import java.util.Objects;

/**
 * The card in a deck. A combination of {@link CardRank} and {@link CardSuit}
 */
public class Card implements Comparable{

	private CardRank rank;
	private CardSuit suit;

	public Card(CardRank rank, CardSuit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	/**
	 * @return The {@link CardRank}
	 */
	public CardRank getRank() {
		return rank;
	}

	/**
	 * @return The {@link CardSuit}
	 */
	public CardSuit getSuit() {
		return suit;
	}

	/**
	 * @return The CSS class of the card, e.g. <code>card-red</code>
	 */
	public String styleClass() {
		return "card-" + suit.getColor();
	}

	/**
	 * @return The combination of the {@link CardRank} and {@link CardSuit}, e.g. Ace of Hearts is
	 * <code>A&hearts;</code>
	 */
	public String toString() {
		return getRank().toString() + getSuit().toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Card card = (Card) o;
		return rank == card.rank &&
				suit == card.suit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(rank, suit);
	}

	@Override
	public int compareTo(Object o) {
		Card card = (Card)o;
		return Integer.compare(this.rank.ordinal(), card.rank.ordinal());
		//(this.rank.ordinal()  < card.rank.ordinal()) ? -1 : ((this.rank.ordinal() == card.rank.ordinal()) ? 0 : 1);

	}

}
