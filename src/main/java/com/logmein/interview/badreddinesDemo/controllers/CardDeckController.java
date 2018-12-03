package com.logmein.interview.badreddinesDemo.controllers;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.logmein.interview.badreddinesDemo.dao.model.Game;
import com.logmein.interview.badreddinesDemo.exceptions.AppException;
import com.logmein.interview.badreddinesDemo.services.CardDeckService;
import com.logmein.interview.badreddinesDemo.services.DeckCardCreatorService;
import com.logmein.interview.badreddinesDemo.services.beans.card.CardCount;
import com.logmein.interview.badreddinesDemo.services.beans.card.CardSuit;
import com.logmein.interview.badreddinesDemo.services.beans.deck.DeckOfCards;

@RestController
@RequestMapping(value = "/deck")
public class CardDeckController {
	@Autowired
	@Qualifier("deckCardCreatorService")
	private DeckCardCreatorService deckCardCreatorService;

	@Autowired
	@Qualifier("cardDeckService")
	private CardDeckService cardDeckService;

	@GetMapping(value = "/create")
	public ResponseEntity<Object> getCreateDeckOfCards() {
		try {
			final DeckOfCards createDeckOfCards = this.deckCardCreatorService.createDeckOfCards();
			if (createDeckOfCards == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(createDeckOfCards, HttpStatus.OK);
			}
		} catch (AppException e) {
			// TODO:Should add logs and handle exceptions by AOP
			return new ResponseEntity<>(e.getMessage(), HttpStatus.resolve(e.getStatus()));
		} catch (Exception e) {
			// TODO:Should add logs and handle exceptions by AOP
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = "/addToGame")
	public ResponseEntity<Object> postAddDeckToGameDeck(@RequestParam(required = true) String gameName) {
		try {
			final Game game = this.cardDeckService.addDeckToGameDeck(gameName);
			if (game == null) {
				return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
			} else {
				return new ResponseEntity<>(game, HttpStatus.CREATED);
			}
		} catch (AppException e) {
			// TODO:Should add logs and handle exceptions by AOP
			return new ResponseEntity<>(e.getMessage(), HttpStatus.resolve(e.getStatus()));
		} catch (Exception e) {
			// TODO:Should add logs and handle exceptions by AOP
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/cardsPerSuit")
	public ResponseEntity<Object> getNumberOfCardsPerSuitInGameDeck(@RequestParam(required = true) String gameName) {
		// Get the count of how many cards per suit are left undealt in the game deck
		try {
			final Map<CardSuit, Long> cardsPerSuit = this.cardDeckService.numberOfCardsPerSuitInGameDeck(gameName);
			if (cardsPerSuit == null || cardsPerSuit.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(cardsPerSuit, HttpStatus.OK);
			}
		} catch (AppException e) {
			// TODO:Should add logs and handle exceptions by AOP
			return new ResponseEntity<>(e.getMessage(), HttpStatus.resolve(e.getStatus()));
		} catch (Exception e) {
			// TODO:Should add logs and handle exceptions by AOP
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/remaining")
	public ResponseEntity<Object> getRemainingCardsInGameDeck(@RequestParam(required = true) String gameName) {
		// Get the count of how many cards per suit are left undealt in the game deck
		try {
			final Set<CardCount> setOfCardCount = this.cardDeckService.remainingCardsInGameDeck(gameName);
			if (setOfCardCount == null || setOfCardCount.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(setOfCardCount, HttpStatus.OK);
			}
		} catch (AppException e) {
			// TODO:Should add logs and handle exceptions by AOP
			return new ResponseEntity<>(e.getMessage(), HttpStatus.resolve(e.getStatus()));
		} catch (Exception e) {
			// TODO:Should add logs and handle exceptions by AOP
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
