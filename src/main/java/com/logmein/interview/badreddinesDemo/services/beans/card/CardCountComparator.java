package com.logmein.interview.badreddinesDemo.services.beans.card;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CardCountComparator implements Comparator<CardCount> {
	final Map<CardSuit, Integer> map = new HashMap<>();
	{
		map.put(CardSuit.HEART, 4);
		map.put(CardSuit.SPADE, 3);
		map.put(CardSuit.CLUB, 2);
		map.put(CardSuit.DIAMOND, 1);
	}

	@Override
	public int compare(CardCount o1, CardCount o2) {
		final Integer s1 = this.map.get(o1.getCardSuit());
		final Integer s2 = this.map.get(o2.getCardSuit());
		if (s1.equals(s2)) {
			return -1 * o1.getCardNumber().compareTo(o2.getCardNumber());
		} else {
			return -1 * s1.compareTo(s2);
		}
	}

}
