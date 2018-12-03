package com.logmein.interview.badreddinesDemo.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.logmein.interview.badreddinesDemo.dao.model.GamePlayer;
import com.logmein.interview.badreddinesDemo.dao.model.GamePlayerCard;
import com.logmein.interview.badreddinesDemo.exceptions.AppException;
import com.logmein.interview.badreddinesDemo.services.GameService;
import com.logmein.interview.badreddinesDemo.services.PlayerService;
import com.logmein.interview.badreddinesDemo.services.beans.card.Card;
import com.logmein.interview.badreddinesDemo.services.beans.player.PlayerBean;

@RestController
@RequestMapping(value = "/player")
public class PlayerController {
	@Autowired
	@Qualifier("gameService")
	private GameService gameService;
	@Autowired
	@Qualifier("playerService")
	private PlayerService playerService;

	@PostMapping(value = "/addToGame")
	public ResponseEntity<Object> addPlayerToGame(@RequestParam(required = true) String gameName,
			@RequestParam(required = true) String playerName) {
		try {
			final GamePlayer gamePlayer = this.gameService.addPlayerToGame(gameName, playerName);
			if (gamePlayer == null) {
				return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
			} else {
				return new ResponseEntity<>(gamePlayer, HttpStatus.CREATED);
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

	@DeleteMapping(value = "/removeFromGame")
	public ResponseEntity<Object> removePlayerFromGame(@RequestParam String gameName, @RequestParam String playerName) {
		try {
			final boolean removePlayerFromGame = this.gameService.removePlayerFromGame(gameName, playerName);
			if (removePlayerFromGame) {
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

	@PostMapping(value = "/deal")
	public ResponseEntity<Object> deal(@RequestParam(required = true) String gameName,
			@RequestParam(required = true) String playerName) {
		try {
			final GamePlayerCard dealed = this.playerService.dealToPlayer(gameName, playerName);
			if (dealed == null) {
				return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
			} else {
				return new ResponseEntity<>(dealed, HttpStatus.CREATED);
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

	@PostMapping(value = "/shuffle")
	public ResponseEntity<Object> shuffleTheGameDeck(@RequestParam(required = true) String gameName) {
		try {
			final Iterable<Card> lstCards = this.playerService.shuffleTheGameDeck(gameName);
			if (lstCards == null) {
				return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
			} else {
				return new ResponseEntity<>(HttpStatus.CREATED);
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

	@GetMapping(value = "/listOfCards")
	public ResponseEntity<Object> listOfCards(@RequestParam String gameName, @RequestParam String playerName) {
		try {
			final List<Card> lstCard = this.playerService.listOfPlayerCards(gameName, playerName);
			if (lstCard == null || lstCard.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(lstCard, HttpStatus.OK);
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
	
	
	@GetMapping(value = "/totalAddedValue")
	public ResponseEntity<Object> playersValues(@RequestParam(required = true) String gameName) {
		try {
			final Set<PlayerBean> playersValues = this.playerService.playersTotalHoldValues(gameName);
			if (playersValues == null || playersValues.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(playersValues, HttpStatus.OK);
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
