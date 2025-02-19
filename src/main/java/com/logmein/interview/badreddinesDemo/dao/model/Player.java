package com.logmein.interview.badreddinesDemo.dao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(of = "playerId")
@Getter
@Setter
@ToString
@Entity
public class Player {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int playerId;
	private String playerName;

	@OneToOne
	private GamePlayer gamePlayer;

}
