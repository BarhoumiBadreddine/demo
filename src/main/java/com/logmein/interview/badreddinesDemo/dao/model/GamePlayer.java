package com.logmein.interview.badreddinesDemo.dao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class GamePlayer {
	@Id
	private GamePlayerPk id;

	private Integer playerOrder;

	@ManyToOne
	private Game game;
	@OneToOne
	private Player player;

}
