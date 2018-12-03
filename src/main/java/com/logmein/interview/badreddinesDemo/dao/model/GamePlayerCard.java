package com.logmein.interview.badreddinesDemo.dao.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class GamePlayerCard {
	@Id
	private GamePlayerCardPk id;
	private int cardSuit;
	private int cardNumber;
	@ManyToOne
	private Game game;

	@ManyToOne
	private Player player;

	public GamePlayerCardPk getId() {
		return id;
	}

	public void setId(GamePlayerCardPk id) {
		this.id = id;
	}

	public int getCardSuit() {
		return cardSuit;
	}

	public void setCardSuit(int cardSuit) {
		this.cardSuit = cardSuit;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
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
		GamePlayerCard other = (GamePlayerCard) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GamePlayerCard [id=");
		builder.append(id);
		builder.append(", cardSuit=");
		builder.append(cardSuit);
		builder.append(", cardNumber=");
		builder.append(cardNumber);
		builder.append(", game=");
		builder.append(game);
		builder.append(", player=");
		builder.append(player);
		builder.append("]");
		return builder.toString();
	}

}
