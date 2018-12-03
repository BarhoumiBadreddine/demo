package com.logmein.interview.badreddinesDemo.services;

import java.util.List;

import com.logmein.interview.badreddinesDemo.dao.model.GameDeckCard;

public interface ShuffleDeckGameService {

	void shuffleGameDeck(List<GameDeckCard> list);

}
