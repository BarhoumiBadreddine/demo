package com.logmein.interview.badreddinesDemo.dao.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public record GamePlayerPk(int gameId, int playerId) implements Serializable {
	private static final long serialVersionUID = 1L;
} 
