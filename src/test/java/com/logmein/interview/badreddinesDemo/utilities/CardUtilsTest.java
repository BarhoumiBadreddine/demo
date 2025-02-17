package com.logmein.interview.badreddinesDemo.utilities;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.logmein.interview.badreddinesDemo.services.beans.card.Card;
import com.logmein.interview.badreddinesDemo.services.beans.card.CardType;
import com.logmein.interview.badreddinesDemo.services.beans.deck.DeckOfCards;

public class CardUtilsTest {

	@Test
	public void createCardsForEachSuiteIntegerInteger() {

		try {
			final Integer min = null;
			final Integer max = null;
			CardUtils.createCardsForEachSuite(min, max);
			fail("Expected an IllegalArgumentException to be thrown!");
		} catch (IllegalArgumentException expected) {
			assertThat(expected.getMessage()).isEqualTo("[Assertion failed] - 'min' argument is required; it must not be null");
		} catch (Exception unexpected) {
			fail("Expected an IllegalArgumentException to be thrown! got : " + unexpected.getClass().getSimpleName());
		}
		try {
			final Integer min = 1;
			final Integer max = null;
			CardUtils.createCardsForEachSuite(min, max);
			fail("Expected an IllegalArgumentException to be thrown!");
		} catch (IllegalArgumentException expected) {
			assertThat(expected.getMessage()).isEqualTo("[Assertion failed] - 'max' argument is required; it must not be null");
		} catch (Exception unexpected) {
			fail("Expected an IllegalArgumentException to be thrown! got : " + unexpected.getClass().getSimpleName());
		}
		try {
			final Integer min = 1;
			final Integer max = null;
			CardUtils.createCardsForEachSuite(min, max);
			fail("Expected an IllegalArgumentException to be thrown!");
		} catch (IllegalArgumentException expected) {
			assertThat(expected.getMessage()).isEqualTo("[Assertion failed] - 'max' argument is required; it must not be null");
		} catch (Exception unexpected) {
			fail("Expected an IllegalArgumentException to be thrown! got : " + unexpected.getClass().getSimpleName());
		}
		try {
			final Integer min = 5;
			final Integer max = 4;
			CardUtils.createCardsForEachSuite(min, max);
			fail("Expected an IllegalArgumentException to be thrown!");
		} catch (IllegalArgumentException expected) {
			assertThat(expected.getMessage()).isEqualTo("'min' argument should be <= 'max'");
		} catch (Exception unexpected) {
			fail("Expected an IllegalArgumentException to be thrown! got : " + unexpected.getClass().getSimpleName());
		}
		try {
			final Integer min = 1;
			final Integer max = 14;
			final ArrayList<Card> actual = CardUtils.createCardsForEachSuite(min, max);
			assertThat(actual).isNotNull();
			assertThat(actual.isEmpty()).isEqualTo(false);
			assertThat(actual.size()).isEqualTo(52);
			fail("Expected an IllegalStateException to be thrown!");
		} catch (IllegalStateException expected) {
			assertThat(expected.getMessage()).isEqualTo("No card type for cardNumber[14]!");
		} catch (Exception unexpected) {
			fail("Expected an IllegalStateException to be thrown! got : " + unexpected.getClass().getSimpleName());
		}
		{
			final Integer min = 5;
			final Integer max = 5;
			final ArrayList<Card> actual = CardUtils.createCardsForEachSuite(min, max);
			assertThat(actual).isNotNull();
			assertThat(actual.isEmpty()).isEqualTo(false);
			assertThat(actual.size()).isEqualTo(4);
		}
		{
			final Integer min = 1;
			final Integer max = 13;
			final ArrayList<Card> actual = CardUtils.createCardsForEachSuite(min, max);
			assertThat(actual).isNotNull();
			assertThat(actual.isEmpty()).isEqualTo(false);
			assertThat(actual.size()).isEqualTo(52);
		}

	}

	@Test
	public void createCardsForEachSuiteCardType() {
		try {
			final CardType cardType = null;
			CardUtils.createCardsForEachSuite(cardType);
			fail("Expected an IllegalArgumentException to be thrown!");
		} catch (IllegalArgumentException expected) {
			assertThat(expected.getMessage()).isEqualTo("[Assertion failed] - 'cardType' argument is required; it must not be null");
		} catch (Exception unexpected) {
			fail("Expected an IllegalArgumentException to be thrown! got : " + unexpected.getClass().getSimpleName());
		}
		{
			final CardType cardType = CardType.ACE;
			final ArrayList<Card> actual = CardUtils.createCardsForEachSuite(cardType);
			assertThat(actual).isNotNull();
			assertThat(actual.isEmpty()).isEqualTo(false);
			assertThat(actual.size()).isEqualTo(4);
		}
		{
			final CardType cardType = CardType.NUMBER;
			final ArrayList<Card> actual = CardUtils.createCardsForEachSuite(cardType);
			assertThat(actual).isNotNull();
			assertThat(actual.isEmpty()).isEqualTo(false);
			assertThat(actual.size()).isEqualTo(36);
		}
		{
			final CardType cardType = CardType.JACK;
			final ArrayList<Card> actual = CardUtils.createCardsForEachSuite(cardType);
			assertThat(actual).isNotNull();
			assertThat(actual.isEmpty()).isEqualTo(false);
			assertThat(actual.size()).isEqualTo(4);
		}
		{
			final CardType cardType = CardType.QUEEN;
			final ArrayList<Card> actual = CardUtils.createCardsForEachSuite(cardType);
			assertThat(actual).isNotNull();
			assertThat(actual.isEmpty()).isEqualTo(false);
			assertThat(actual.size()).isEqualTo(4);
		}
		{
			final CardType cardType = CardType.KING;
			final ArrayList<Card> actual = CardUtils.createCardsForEachSuite(cardType);
			assertThat(actual).isNotNull();
			assertThat(actual.isEmpty()).isEqualTo(false);
			assertThat(actual.size()).isEqualTo(4);
		}
	}

	@Test
	public void fillCards() {
		try {
			final DeckOfCards deckOfCards = null;
			CardUtils.fillCards(deckOfCards);
			fail("Expected an IllegalArgumentException to be thrown!");
		} catch (IllegalArgumentException expected) {
			assertThat(expected.getMessage()).isEqualTo("[Assertion failed] - 'deckOfCards' argument is required; it must not be null");
		} catch (Exception unexpected) {
			fail("Expected an IllegalArgumentException to be thrown! got : " + unexpected.getClass().getSimpleName());
		}

		try {
			final DeckOfCards deckOfCards = new DeckOfCards();
			deckOfCards.addCard(new Card());
			CardUtils.fillCards(deckOfCards);
			fail("Expected an IllegalStateException to be thrown!");
		} catch (IllegalStateException expected) {
			assertThat(expected.getMessage()).isEqualTo("'deckOfCards.getCards()' is not clear!, may be it's already filled!");
		} catch (Exception unexpected) {
			fail("Expected an IllegalStateException to be thrown! got : " + unexpected.getClass().getSimpleName());
		}
		{
			final DeckOfCards deckOfCards = new DeckOfCards();
			CardUtils.fillCards(deckOfCards);
			assertThat(deckOfCards.getCards().size()).isEqualTo(52);
		}
	}

	@Test
	public void getCardType() {
		try {
			final Integer cardNumber = null;
			CardUtils.getCardType(cardNumber);
			fail("Expected an IllegalArgumentException to be thrown!");
		} catch (IllegalArgumentException expected) {
			assertThat(expected.getMessage()).isEqualTo("[Assertion failed] - 'cardNumber' argument is required; it must not be null");
		} catch (Exception unexpected) {
			fail("Expected an IllegalArgumentException to be thrown! got : " + unexpected.getClass().getSimpleName());
		}
	}
}
