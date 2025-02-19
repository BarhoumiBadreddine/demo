package com.logmein.interview.badreddinesDemo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.logmein.interview.badreddinesDemo.dao.model.Game;

public interface GameRepo extends CrudRepository<Game, Integer>{

	List<Game> findByName(String gameName);

	Game findByGameId(int gameId);

}
