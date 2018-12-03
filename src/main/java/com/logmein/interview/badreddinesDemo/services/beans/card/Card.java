package com.logmein.interview.badreddinesDemo.services.beans.card;

import org.springframework.util.Assert;

public class Card {

	private CardSuit cardSuit;
	private Integer cardNumber;
	private CardType cardType;

	public Card() {
	}

	public Card(CardSuit cardSuit, Integer cardNumber, CardType cardType) {
		super();
		Assert.notNull(cardSuit, "[Assertion failed] - 'cardSuit' argument is required; it must not be null");
		Assert.notNull(cardNumber, "[Assertion failed] - 'cardNumber' argument is required; it must not be null");
		Assert.notNull(cardType, "[Assertion failed] - 'cardType' argument is required; it must not be null");

		this.cardSuit = cardSuit;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
	}

	public CardSuit getCardSuit() {
		return cardSuit;
	}

	public void setCardSuit(CardSuit cardSuit) {
		this.cardSuit = cardSuit;
	}

	public Integer getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}

	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Card [cardSuit=");
		builder.append(cardSuit);
		builder.append(", cardNumber=");
		builder.append(cardNumber);
		builder.append(", cardType=");
		builder.append(cardType);
		builder.append("]");
		return builder.toString();
	}

}
