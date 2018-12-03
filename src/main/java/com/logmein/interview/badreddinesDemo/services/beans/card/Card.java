package com.logmein.interview.badreddinesDemo.services.beans.card;

import org.springframework.util.Assert;

public class Card {

	private final CardSuit cardSuit;
	private final Integer cardNumber;
	private final CardType cardType;

	public Card(CardSuit cardSuit, Integer cardNumber, CardType cardType) {
		super();
		Assert.notNull(cardSuit, "[Assertion failed] - 'cardSuit' argument is required; it must not be null");
		Assert.notNull(cardNumber, "[Assertion failed] - 'cardNumber' argument is required; it must not be null");

		this.cardSuit = cardSuit;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
	}

	public CardSuit getCardSuit() {
		return cardSuit;
	}

	public Integer getCardNumber() {
		return cardNumber;
	}

	@Override
	public String toString() {
		return "Card [cardSuit=" + cardSuit + ", cardNumber=" + cardNumber + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
		result = prime * result + ((cardSuit == null) ? 0 : cardSuit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (cardNumber == null) {
			if (other.cardNumber != null)
				return false;
		} else if (!cardNumber.equals(other.cardNumber))
			return false;
		if (cardSuit != other.cardSuit)
			return false;
		return true;
	}

	public CardType getCardType() {
		return cardType;
	}

}
