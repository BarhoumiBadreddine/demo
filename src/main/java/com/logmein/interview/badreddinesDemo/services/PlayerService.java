package com.logmein.interview.badreddinesDemo.services;

import java.util.List;
import java.util.Set;

import com.logmein.interview.badreddinesDemo.dao.model.GamePlayerCard;
import com.logmein.interview.badreddinesDemo.services.beans.card.Card;
import com.logmein.interview.badreddinesDemo.services.beans.player.PlayerBean;

public interface PlayerService {

	GamePlayerCard dealToPlayer(String gameName, String playerName);

	List<Card> listOfPlayerCards(String gameName, String playerName);

	List<Card> shuffleTheGameDeck(String gameName);

	Set<PlayerBean> playersTotalHoldValues(String gameName);

}
