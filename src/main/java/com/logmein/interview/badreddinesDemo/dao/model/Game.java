package com.logmein.interview.badreddinesDemo.dao.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
/**
 * 
 * @author bbarhoumi
 *
 */
 
@Entity
public class Game {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int gameId;
	private String name;
	private int decksNumber;
//	private int playerCreatedBy;

	@OneToMany(mappedBy = "id.gameId")
	private List<GameDeckCard> gameDeck;
	
	@OneToMany(mappedBy = "id.gameId")
	private List<GamePlayer> lstGamePlayers;

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDecksNumber() {
		return decksNumber;
	}

	public void setDecksNumber(int decksNumber) {
		this.decksNumber = decksNumber;
	}

//	public int getPlayerCreatedBy() {
//		return playerCreatedBy;
//	}
//
//	public void setPlayerCreatedBy(int playerCreatedBy) {
//		this.playerCreatedBy = playerCreatedBy;
//	}

	public List<GameDeckCard> getGameDeck() {
		return gameDeck;
	}

	public void setGameDeck(List<GameDeckCard> gameDeck) {
		this.gameDeck = gameDeck;
	}

	public List<GamePlayer> getLstGamePlayers() {
		return lstGamePlayers;
	}

	public void setLstGamePlayers(List<GamePlayer> lstGamePlayers) {
		this.lstGamePlayers = lstGamePlayers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gameId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		if (gameId != other.gameId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Game [gameId=");
		builder.append(gameId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", decksNumber=");
		builder.append(decksNumber);
//		builder.append(", playerCreatedBy=");
//		builder.append(playerCreatedBy);
		builder.append("]");
		return builder.toString();
	}

	
}
