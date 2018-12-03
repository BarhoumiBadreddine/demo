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

import com.logmein.interview.badreddinesDemo.dao.model.Game;
import com.logmein.interview.badreddinesDemo.exceptions.AppException;
import com.logmein.interview.badreddinesDemo.services.GameService;

@RestController
@RequestMapping(value = "/game")
public class GameController {
	@Autowired
	@Qualifier(value = "gameService")
	private GameService gameService;

	@PostMapping(value = "/create")
	public ResponseEntity<Object> createGame(@RequestParam(required = true) String gameName) {
		Assert.hasText(gameName,
				"[Assertion failed] - 'gameName' String argument must have text; it must not be null, empty, or blank");
		try {
			final Game newGame = this.gameService.createGame(gameName);
			if (newGame == null) {
				return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
			} else {
				return new ResponseEntity<>(newGame, HttpStatus.CREATED);
			}
		} catch (AppException e) {
			// TODO:Should add logs and handle  exceptions by AOP
			return new ResponseEntity<>(e.getMessage(), HttpStatus.resolve(e.getStatus()));
		} catch (Exception e) {
			// TODO:Should add logs and handle  exceptions by AOP
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping(value = "/delete")
	public ResponseEntity<Object> deleteGame(@RequestParam(required = true) String gameName) {
		try {
			final boolean deleteGame = this.gameService.deleteGame(gameName);
			if (deleteGame) {
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
			}
		} catch (AppException e) {
			// TODO:Should add logs and handle  exceptions by AOP
			return new ResponseEntity<>(e.getMessage(), HttpStatus.resolve(e.getStatus()));
		} catch (Exception e) {
			// TODO:Should add logs and handle  exceptions by AOP
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
