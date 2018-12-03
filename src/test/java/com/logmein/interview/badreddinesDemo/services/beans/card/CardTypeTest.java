package com.logmein.interview.badreddinesDemo.services.beans.card;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.fail;

import org.testng.annotations.Test;

public class CardTypeTest {

	@Test
	public void testCardTypeNumber() {
		final CardType[] values = CardType.values();
		final int expected = 5;
		final int actual = values.length;
		assertThat(actual, equalTo(expected));
	}

	@Test
	public void testMinMaxValues() {
		final CardType[] values = CardType.values();
		for (CardType cardType : values) {
			switch (cardType) {
			case ACE:
				assertThat(cardType.getMin(), equalTo(1));
				assertThat(cardType.getMax(), equalTo(1));
				break;
			case NUMBER:
				assertThat(cardType.getMin(), equalTo(2));
				assertThat(cardType.getMax(), equalTo(10));
				break;
			case JACK:
				assertThat(cardType.getMin(), equalTo(11));
				assertThat(cardType.getMax(), equalTo(11));
				break;
			case QUEEN:
				assertThat(cardType.getMin(), equalTo(12));
				assertThat(cardType.getMax(), equalTo(12));
				break;
			case KING:
				assertThat(cardType.getMin(), equalTo(13));
				assertThat(cardType.getMax(), equalTo(13));
				break;
			default:
				fail("Value not handled, please add it above!");
				break;
			}
		}
	}

	@Test
	public void testIsFaceCard() {

		final CardType[] values = CardType.values();
		for (CardType cardType : values) {
			switch (cardType) {
			case ACE:
			case NUMBER:
				assertThat(cardType.isFaceCard(), equalTo(false));
				break;
			case JACK:
			case QUEEN:
			case KING:
				assertThat(cardType.isFaceCard(), equalTo(true));
				break;
			default:
				fail("Value not handled, please add it above!");
				break;
			}
		}

	}
}
