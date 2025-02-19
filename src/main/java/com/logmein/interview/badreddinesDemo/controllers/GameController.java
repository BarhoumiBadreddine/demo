package com.logmein.interview.badreddinesDemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.logmein.interview.badreddinesDemo.dao.model.Game;
import com.logmein.interview.badreddinesDemo.services.GameService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@Slf4j
@RestController
@RequestMapping(value = "/games")
public class GameController {
	@Autowired
	@Qualifier(value = "gameService")
	private GameService gameService;

	@GetMapping(name = "/{id}", produces = "application/json")
	public ResponseEntity<Game> getGame(@PathVariable Integer id) {
		final Game newGame = this.gameService.findByGameId(id);
		return ResponseEntity.ok(newGame);

	}

	@PostMapping
	public ResponseEntity<Void> createGame(@RequestParam(required = true) String gameName, UriComponentsBuilder uriBuilder) {
		Assert.hasText(gameName,
				"[Assertion failed] - 'gameName' String argument must have text; it must not be null, empty, or blank");
		try {
			final Game newGame = this.gameService.createGame(gameName);
			if (newGame == null) {
				return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
			} else {
				return ResponseEntity.created(uriBuilder.path("/game/{id}").buildAndExpand(newGame.getGameId()).toUri()).build();
			}
		} catch (Exception e) {
			// TODO:Should add logs and handle  exceptions by AOP
			log.error("Error adding new game", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping
	public ResponseEntity<Void> deleteGame(@RequestParam(required = true) String gameName) {
		try {
			final boolean deleteGame = this.gameService.deleteGame(gameName);
			if (deleteGame) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
			}
		} catch (Exception e) {
			// TODO:Should add logs and handle  exceptions by AOP
			log.error("Error adding new game", e);
			return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
