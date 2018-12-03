package com.logmein.interview.badreddinesDemo.services.beans.card;

public enum CardSuit {
	CLUB("BLACK", 1), DIAMOND("RED", 2), HEART("RED", 3), SPADE("BLACK", 4);
	private final String color;
	private final int id;

	private CardSuit(String color, int id) {
		this.color = color;
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public int getId() {
		return id;
	}

	public static CardSuit valueOf(int id) {
		for (CardSuit value : CardSuit.values()) {
			if (value.id == id) {
				return value;
			}
		}
		throw new IllegalStateException("There is no value with id[" + id + "]");
	}

}
