package com.logmein.interview.badreddinesDemo.services.beans.card;

public enum CardType {
	ACE(1), NUMBER(2, 10), JACK(11, true), QUEEN(12, true), KING(13, true);
	private final Integer min;
	private final Integer max;
	private final boolean faceCard;

	private CardType(Integer min, Integer max, boolean faceCard) {
		this.min = min;
		this.max = max;
		this.faceCard = faceCard;
	}

	private CardType(Integer min, Integer max) {
		this(min, max, false);
	}

	private CardType(Integer oneVlue) {
		this(oneVlue, oneVlue, false);
	}

	private CardType(Integer oneVlue, boolean faceCard) {
		this(oneVlue, oneVlue, faceCard);
	}

	public Integer getMin() {
		return min;
	}

	public Integer getMax() {
		return max;
	}

	public boolean isFaceCard() {
		return faceCard;
	}

}
