package com.logmein.interview.badreddinesDemo.services.beans.card;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEqualsFor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCodeFor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanToString;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.fail;

import org.testng.annotations.Test;

public class CardTest {

	@Test
	public void testCard() {
		{
			final Card actual = new Card();
			assertThat(actual, notNullValue());
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
			assertThat(expected.getMessage(),
					equalTo("[Assertion failed] - 'cardSuit' argument is required; it must not be null"));
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
			assertThat(expected.getMessage(),
					equalTo("[Assertion failed] - 'cardNumber' argument is required; it must not be null"));
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
			assertThat(expected.getMessage(),
					equalTo("[Assertion failed] - 'cardType' argument is required; it must not be null"));
		} catch (Exception unexpected) {
			fail("Expected an IllegalArgumentException to be thrown! got : " + unexpected.getClass().getSimpleName());
		}

		{
			final CardSuit cardSuit = CardSuit.CLUB;
			final Integer cardNumber = 1;
			final CardType cardType = CardType.ACE;
			final Card actual = new Card(cardSuit, cardNumber, cardType);
			assertThat(actual, notNullValue());
		}
	}

	@Test
	public void testGettersAndSetters() {
		assertThat(Card.class, hasValidGettersAndSetters());
	}

	@Test
	public void testEquals() {
		assertThat(Card.class, hasValidBeanEqualsFor("cardSuit", "cardNumber"));
	}

	@Test
	public void testHashCode() {
		assertThat(Card.class, hasValidBeanHashCodeFor("cardSuit", "cardNumber"));
	}

	@Test
	public void testToString() {
		assertThat(Card.class, hasValidBeanToString());
	}
}
