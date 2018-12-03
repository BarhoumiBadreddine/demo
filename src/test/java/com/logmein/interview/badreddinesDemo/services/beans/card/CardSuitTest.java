package com.logmein.interview.badreddinesDemo.services.beans.card;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.fail;

import org.testng.annotations.Test;

public class CardSuitTest {

	@Test
	public void testCardSuitNumber() {
		final CardSuit[] values = CardSuit.values();
		final int expected = 4;
		final int actual = values.length;
		assertThat(actual, equalTo(expected));
	}

	@Test
	public void testCardSuitColors() {
		final CardSuit[] values = CardSuit.values();
		for (CardSuit cardSuit : values) {
			switch (cardSuit) {
			case CLUB:
			case SPADE:
				assertThat(cardSuit.getColor(), equalTo("BLACK"));
				break;
			case DIAMOND:
			case HEART:
				assertThat(cardSuit.getColor(), equalTo("RED"));
				break;
			default:
				fail("Value not handled, please add it above!");
				break;
			}
		}
	}

	@Test
	public void getCardSuitIds() {
		final CardSuit[] values = CardSuit.values();
		for (CardSuit cardSuit : values) {
			switch (cardSuit) {
			case CLUB:
				assertThat(cardSuit.getId(), equalTo(1));
				break;
			case SPADE:
				assertThat(cardSuit.getId(), equalTo(4));
				break;
			case DIAMOND:
				assertThat(cardSuit.getId(), equalTo(2));
				break;
			case HEART:
				assertThat(cardSuit.getId(), equalTo(3));
				break;
			default:
				fail("Value not handled, please add it above!");
				break;
			}
		}
	}

	@Test
	public void testValueOf() {
		try {
			CardSuit.valueOf(7);
			fail("Expected an IllegalStateException to be thrown!");
		} catch (IllegalStateException expected) {
			assertThat(expected.getMessage(), equalTo("There is no value with id[7]!"));
		} catch (Exception unexpected) {
			fail("Expected an IllegalStateException to be thrown! got : " + unexpected.getClass().getSimpleName());
		}

		{
			final CardSuit expected = CardSuit.CLUB;
			final CardSuit actual = CardSuit.valueOf(1);
			assertThat(actual, equalTo(expected));
		}
		{
			final CardSuit expected = CardSuit.DIAMOND;
			final CardSuit actual = CardSuit.valueOf(2);
			assertThat(actual, equalTo(expected));
		}
		{
			final CardSuit expected = CardSuit.HEART;
			final CardSuit actual = CardSuit.valueOf(3);
			assertThat(actual, equalTo(expected));
		}
		{
			final CardSuit expected = CardSuit.SPADE;
			final CardSuit actual = CardSuit.valueOf(4);
			assertThat(actual, equalTo(expected));
		}

	}
}
