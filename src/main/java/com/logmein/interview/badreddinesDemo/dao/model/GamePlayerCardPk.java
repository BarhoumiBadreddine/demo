package com.logmein.interview.badreddinesDemo.dao.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Setter;


@Embeddable
public record GamePlayerCardPk(int gameId, int playerId, int cardId) implements Serializable {
	private static final long serialVersionUID = 1L;
} 
