package com.logmein.interview.badreddinesDemo.dao.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class GameDeckCardPk implements Serializable {
	private static final long serialVersionUID = 1L;
	private int gameId;
	private int cardId;
}
