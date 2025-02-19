package com.logmein.interview.badreddinesDemo.dao.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;
/**
 * 
 * @author bbarhoumi
 *
 */
@With
@Builder
@Data
@EqualsAndHashCode(of = "gameId")
@NoArgsConstructor
@AllArgsConstructor
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
	
}
