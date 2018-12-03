package com.logmein.interview.badreddinesDemo.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.logmein.interview.badreddinesDemo.dao.model.Player;

public interface PlayerRepo extends CrudRepository<Player, Integer>{

	Optional<Player> findByPlayerName(String playerName);
}
