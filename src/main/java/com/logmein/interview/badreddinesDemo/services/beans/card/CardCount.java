package com.logmein.interview.badreddinesDemo.services.beans.card;

public class CardCount extends Card{
	private final Long numberOfCards;

	public CardCount(CardSuit cardSuit, Integer cardNumber, CardType cardType, Long numberOfCards) {
		super(cardSuit, cardNumber, cardType);
		this.numberOfCards = numberOfCards;
	}

	public Long getNumberOfCards() {
		return numberOfCards;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CardCount [numberOfCards=");
		builder.append(numberOfCards);
		builder.append(", getCardSuit()=");
		builder.append(getCardSuit());
		builder.append(", getCardNumber()=");
		builder.append(getCardNumber());
		builder.append(", getCardType()=");
		builder.append(getCardType());
		builder.append("]");
		return builder.toString();
	}

	


	
}
