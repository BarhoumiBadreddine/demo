package com.logmein.interview.badreddinesDemo.dao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class GameDeckCard {
	@Id
	private GameDeckCardPk id;
	private int cardSuit;
	private int cardNumber;
	private int cardOrder;

	@ManyToOne
	private Game game;

	public GameDeckCardPk getId() {
		return id;
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

	public void setId(GameDeckCardPk id) {
		this.id = id;
	}

	public int getCardOrder() {
		return cardOrder;
	}

	public void setCardOrder(int cardOrder) {
		this.cardOrder = cardOrder;
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
		GameDeckCard other = (GameDeckCard) obj;
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
		builder.append("GameDeckCard [id=");
		builder.append(id);
		builder.append(", cardSuit=");
		builder.append(cardSuit);
		builder.append(", cardNumber=");
		builder.append(cardNumber);
		builder.append(", cardOrder=");
		builder.append(cardOrder);
		builder.append(", game=");
		builder.append(game);
		builder.append("]");
		return builder.toString();
	}

}
