package com.logmein.interview.badreddinesDemo.services.beans.card;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEqualsFor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCodeFor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanToString;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class CardTest {

	@Test
	public void testCard() {
		{
			final Card actual = new Card();
			assertThat(actual).isNotNull();
		}
	}

	@Test
	public void testCard_$CardSuitIntegerCardType() {
		try {
			final CardSuit cardSuit = null;
			final Integer cardNumber = null;
			final CardType cardType = null;
			new Card(cardSuit, cardNumber, cardType);
			fail("Expected an IllegalArgumentException to be thrown!");
		} catch (IllegalArgumentException expected) {
			assertThat(expected.getMessage()).isEqualTo("[Assertion failed] - 'cardSuit' argument is required; it must not be null");
		} catch (Exception unexpected) {
			fail("Expected an IllegalArgumentException to be thrown! got : " + unexpected.getClass().getSimpleName());
		}
		try {
			final CardSuit cardSuit = CardSuit.CLUB;
			final Integer cardNumber = null;
			final CardType cardType = null;
			new Card(cardSuit, cardNumber, cardType);
			fail("Expected an IllegalArgumentException to be thrown!");
		} catch (IllegalArgumentException expected) {
			assertThat(expected.getMessage()).isEqualTo("[Assertion failed] - 'cardNumber' argument is required; it must not be null");
		} catch (Exception unexpected) {
			fail("Expected an IllegalArgumentException to be thrown! got : " + unexpected.getClass().getSimpleName());
		}
		try {
			final CardSuit cardSuit = CardSuit.CLUB;
			final Integer cardNumber = 1;
			final CardType cardType = null;
			new Card(cardSuit, cardNumber, cardType);
			fail("Expected an IllegalArgumentException to be thrown!");
		} catch (IllegalArgumentException expected) {
			assertThat(expected.getMessage()).isEqualTo("[Assertion failed] - 'cardType' argument is required; it must not be null");
		} catch (Exception unexpected) {
			fail("Expected an IllegalArgumentException to be thrown! got : " + unexpected.getClass().getSimpleName());
		}

		{
			final CardSuit cardSuit = CardSuit.CLUB;
			final Integer cardNumber = 1;
			final CardType cardType = CardType.ACE;
			final Card actual = new Card(cardSuit, cardNumber, cardType);
			assertThat(actual).isNotNull();
		}
	}

	@Test
	public void testGettersAndSetters() {
		assertThat(hasValidGettersAndSetters().matches(Card.class)).isTrue();
	}

	@Test
	public void testEquals() {
		assertThat(hasValidBeanEqualsFor("cardSuit", "cardNumber").matches(Card.class)).isTrue();
	}

	@Test
	public void testHashCode() {
		assertThat(hasValidBeanHashCodeFor("cardSuit", "cardNumber").matches(Card.class)).isTrue();
	}

	@Test
	public void testToString() {
		assertThat(hasValidBeanToString().matches(Card.class)).isTrue();
	}
}
