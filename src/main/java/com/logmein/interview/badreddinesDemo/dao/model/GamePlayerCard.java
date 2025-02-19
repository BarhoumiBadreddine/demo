package com.logmein.interview.badreddinesDemo.dao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(of = "id")
@Getter
@Setter
@ToString
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



}
