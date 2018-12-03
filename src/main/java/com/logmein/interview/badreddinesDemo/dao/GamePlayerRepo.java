package com.logmein.interview.badreddinesDemo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.logmein.interview.badreddinesDemo.dao.model.GamePlayer;
import com.logmein.interview.badreddinesDemo.dao.model.GamePlayerPk;

public interface GamePlayerRepo extends CrudRepository<GamePlayer, GamePlayerPk>{

//	Optional<GamePlayer> findByPlayerPlayerName(String name);

	void deleteByIdGameId(int gameId);

	void deleteByIdPlayerId(int playerId);

	@Query("SELECT coalesce(MAX(playerOrder), 0) FROM GamePlayer WHERE id.gameId = ?1")
	Optional<Integer> getMaxPlayerOrder(int gameId);

	Optional<GamePlayer> findByIdPlayerId(int playerId);

	List<GamePlayer> findByIdGameId(int gameId);

	Optional<GamePlayer> findByIdGameIdAndIdPlayerId(int gameId, int playerId);
}
