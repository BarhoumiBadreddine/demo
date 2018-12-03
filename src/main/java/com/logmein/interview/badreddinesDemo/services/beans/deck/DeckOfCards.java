package com.logmein.interview.badreddinesDemo.services.beans.deck;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.util.Assert;

import com.logmein.interview.badreddinesDemo.services.beans.card.Card;

public class DeckOfCards {
	private static final int NUMBER_OF_CARDS = 52;
	private Set<Card> cards;

	public DeckOfCards() {
		this.cards = new HashSet<>();
	}

	public List<Card> getCards() {
		return new ArrayList<>(cards);
	}

	public void addCard(final Card card) {
		Assert.notNull(card, "[Assertion failed] - 'card' argument is required; it must not be null");
		if (this.cards.size() < NUMBER_OF_CARDS) {
			this.cards.add(card);
		} else {
			throw new IllegalStateException("Maximum number of cards, which is[" + NUMBER_OF_CARDS + "], is reached!");
		}
	}

	public boolean isFilled() {
		return this.cards.size() == NUMBER_OF_CARDS;
	}

	public void addCards(final List<Card> cards) {
		Assert.notEmpty(cards, "[Assertion failed] - 'cards' collection must not be empty: it must contain at least 1 element");
		this.cards.addAll(cards);
		
	}

}
