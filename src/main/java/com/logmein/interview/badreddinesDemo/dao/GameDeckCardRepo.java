package com.logmein.interview.badreddinesDemo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.logmein.interview.badreddinesDemo.dao.model.GameDeckCard;
import com.logmein.interview.badreddinesDemo.dao.model.GameDeckCardPk;

public interface GameDeckCardRepo extends CrudRepository<GameDeckCard, GameDeckCardPk>{

	List<GameDeckCard> findByIdGameId(int gameId);
	@Query("SELECT coalesce(MAX(id.cardId), 0) FROM GameDeckCard gdc WHERE id.gameId = ?1")
	Optional<Integer> findMaxIdCardIdByIdGameId(int gameId);
	void deleteByIdGameId(int gameId);
}
