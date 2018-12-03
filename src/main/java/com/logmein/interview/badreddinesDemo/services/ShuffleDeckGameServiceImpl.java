package com.logmein.interview.badreddinesDemo.services;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.logmein.interview.badreddinesDemo.dao.model.GameDeckCard;

@Service(value = "shuffleDeckGameService")
public class ShuffleDeckGameServiceImpl implements ShuffleDeckGameService {
	@Override
	public void shuffleGameDeck(final List<GameDeckCard> listGameDeckCard) {
//		Collections.shuffle(listGameDeckCard);
		Collections.sort(listGameDeckCard, new RandomComparator<>());
	}
	
}