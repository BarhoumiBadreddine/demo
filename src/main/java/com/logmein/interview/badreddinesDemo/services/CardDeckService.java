package com.logmein.interview.badreddinesDemo.services;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.logmein.interview.badreddinesDemo.dao.model.Game;
import com.logmein.interview.badreddinesDemo.dao.model.GameDeckCard;
import com.logmein.interview.badreddinesDemo.services.beans.card.CardCount;
import com.logmein.interview.badreddinesDemo.services.beans.card.CardSuit;
/**
 * 
 * @author bbarhoumi
 *
 */
public interface CardDeckService {
	/**
	 * Assign the deck of cards to the game, and increase the decks number within
	 * the game then update it.
	 * 
	 * @param game            the game to work on it.
	 * @param lstGameDeckCard the 'GameDeckCard' entities list
	 */
	Game addDeckToGameDeck(String gameName);

	void updateGameDeckCardOrder(List<GameDeckCard> lstGameDeckCard);

	Map<CardSuit, Long> numberOfCardsPerSuitInGameDeck(String gameName);

	Set<CardCount> remainingCardsInGameDeck(String gameName);

}
