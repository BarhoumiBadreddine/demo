package com.logmein.interview.badreddinesDemo.services.beans.card;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class CardTypeTest {

	@Test
	public void testCardTypeNumber() {
		final CardType[] values = CardType.values();
		final int expected = 5;
		final int actual = values.length;
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void testMinMaxValues() {
		final CardType[] values = CardType.values();
		for (CardType cardType : values) {
			switch (cardType) {
			case ACE:
				assertThat(cardType.getMin()).isEqualTo(1);
				assertThat(cardType.getMax()).isEqualTo(1);
				break;
			case NUMBER:
				assertThat(cardType.getMin()).isEqualTo(2);
				assertThat(cardType.getMax()).isEqualTo(10);
				break;
			case JACK:
				assertThat(cardType.getMin()).isEqualTo(11);
				assertThat(cardType.getMax()).isEqualTo(11);
				break;
			case QUEEN:
				assertThat(cardType.getMin()).isEqualTo(12);
				assertThat(cardType.getMax()).isEqualTo(12);
				break;
			case KING:
				assertThat(cardType.getMin()).isEqualTo(13);
				assertThat(cardType.getMax()).isEqualTo(13);
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
				assertThat(cardType.isFaceCard()).isEqualTo(false);
				break;
			case JACK:
			case QUEEN:
			case KING:
				assertThat(cardType.isFaceCard()).isEqualTo(true);
				break;
			default:
				fail("Value not handled, please add it above!");
				break;
			}
		}

	}
}
