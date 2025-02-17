package com.logmein.interview.badreddinesDemo.services.beans.card;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class CardSuitTest {

	@Test
	public void testCardSuitNumber() {
		final CardSuit[] values = CardSuit.values();
		final int expected = 4;
		final int actual = values.length;
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void testCardSuitColors() {
		final CardSuit[] values = CardSuit.values();
		for (CardSuit cardSuit : values) {
			switch (cardSuit) {
			case CLUB:
			case SPADE:
				assertThat(cardSuit.getColor()).isEqualTo("BLACK");
				break;
			case DIAMOND:
			case HEART:
				assertThat(cardSuit.getColor()).isEqualTo("RED");
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
				assertThat(cardSuit.getId()).isEqualTo(1);
				break;
			case SPADE:
				assertThat(cardSuit.getId()).isEqualTo(4);
				break;
			case DIAMOND:
				assertThat(cardSuit.getId()).isEqualTo(2);
				break;
			case HEART:
				assertThat(cardSuit.getId()).isEqualTo(3);
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
			assertThat(expected.getMessage()).isEqualTo("There is no value with id[7]!");
		} catch (Exception unexpected) {
			fail("Expected an IllegalStateException to be thrown! got : " + unexpected.getClass().getSimpleName());
		}

		{
			final CardSuit expected = CardSuit.CLUB;
			final CardSuit actual = CardSuit.valueOf(1);
			assertThat(actual).isEqualTo(expected);
		}
		{
			final CardSuit expected = CardSuit.DIAMOND;
			final CardSuit actual = CardSuit.valueOf(2);
			assertThat(actual).isEqualTo(expected);
		}
		{
			final CardSuit expected = CardSuit.HEART;
			final CardSuit actual = CardSuit.valueOf(3);
			assertThat(actual).isEqualTo(expected);
		}
		{
			final CardSuit expected = CardSuit.SPADE;
			final CardSuit actual = CardSuit.valueOf(4);
			assertThat(actual).isEqualTo(expected);
		}

	}
}
