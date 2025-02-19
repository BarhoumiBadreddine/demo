package com.logmein.interview.badreddinesDemo.services;

import com.logmein.interview.badreddinesDemo.dao.model.Game;
import com.logmein.interview.badreddinesDemo.dao.model.GamePlayer;
import com.logmein.interview.badreddinesDemo.dao.model.Player;

public interface GameService {
	/**
	 * Create Game, register user and assign him to the game.
	 * 
	 * @param playerName2
	 * @return the created game with it's new id
	 */
	Game createGame(String gameName);

	boolean deleteGame(String gameName);

	Iterable<Game> findAll();
	
	Game findByGameId(int gameId);

	GamePlayer addPlayerToGame(String gameName, String playerName);

	boolean removePlayerFromGame(String gameName, String playerName);

	Player findRegistredPlayerOrRegisterThis(String playerName);

}
