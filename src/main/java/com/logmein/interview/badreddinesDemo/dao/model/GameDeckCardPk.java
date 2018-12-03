package com.logmein.interview.badreddinesDemo.dao.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class GameDeckCardPk implements Serializable {
	private static final long serialVersionUID = 1L;
	private int gameId;
	private int cardId;

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cardId;
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
		GameDeckCardPk other = (GameDeckCardPk) obj;
		if (cardId != other.cardId)
			return false;
		if (gameId != other.gameId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("GameDeckCardPk [gameId=");
		builder.append(gameId);
		builder.append(", cardId=");
		builder.append(cardId);
		builder.append("]");
		return builder.toString();
	}

}
