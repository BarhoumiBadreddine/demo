package com.logmein.interview.badreddinesDemo.dao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
public class GameDeckCard {
	@Id
	private GameDeckCardPk id;
	private int cardSuit;
	private int cardNumber;
	private int cardOrder;

	@ManyToOne
	private Game game;

}
