package com.logmein.interview.badreddinesDemo.dao.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class GamePlayerPk implements Serializable {
	private static final long serialVersionUID = 1L;
	private int gameId;
	private int playerId;

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gameId;
		result = prime * result + playerId;
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
		GamePlayerPk other = (GamePlayerPk) obj;
		if (gameId != other.gameId)
			return false;
		if (playerId != other.playerId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GamePlayerPk [gameId=");
		builder.append(gameId);
		builder.append(", playerId=");
		builder.append(playerId);
		builder.append("]");
		return builder.toString();
	}

}
