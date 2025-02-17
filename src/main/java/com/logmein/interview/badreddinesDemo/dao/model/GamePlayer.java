package com.logmein.interview.badreddinesDemo.dao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class GamePlayer {
	@Id
	private GamePlayerPk id;

	private Integer playerOrder;

	@ManyToOne
	private Game game;
	@OneToOne
	private Player player;

	public GamePlayerPk getId() {
		return id;
	}

	public void setId(GamePlayerPk id) {
		this.id = id;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		GamePlayer other = (GamePlayer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Integer getPlayerOrder() {
		return playerOrder;
	}

	public void setPlayerOrder(Integer playerOrder) {
		this.playerOrder = playerOrder;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GamePlayer [id=");
		builder.append(id);
		builder.append(", playerOrder=");
		builder.append(playerOrder);
		builder.append(", game=");
		builder.append(game);
		builder.append(", player=");
		builder.append(player);
		builder.append("]");
		return builder.toString();
	}

}
