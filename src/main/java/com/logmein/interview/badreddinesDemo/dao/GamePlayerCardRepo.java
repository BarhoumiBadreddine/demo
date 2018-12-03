package com.logmein.interview.badreddinesDemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.logmein.interview.badreddinesDemo.dao.model.GamePlayerCard;
import com.logmein.interview.badreddinesDemo.dao.model.GamePlayerCardPk;
import com.logmein.interview.badreddinesDemo.services.beans.player.PlayerBean;

public interface GamePlayerCardRepo extends CrudRepository<GamePlayerCard, GamePlayerCardPk>{

	void deleteByIdGameId(int gameId);

	void deleteByIdPlayerId(int playerId);

	List<GamePlayerCard> findByIdGameIdAndIdPlayerId(int gameId, int playerId);
	
	@Query("SELECT new com.logmein.interview.badreddinesDemo.services.beans.player.PlayerBean(id.playerId, coalesce(SUM(cardNumber), 0)) FROM GamePlayerCard  WHERE id.gameId = ?1 GROUP BY id.playerId")
	List<PlayerBean> groupByPlayers(int gameId);


}
