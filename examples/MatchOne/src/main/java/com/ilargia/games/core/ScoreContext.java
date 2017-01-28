package com.ilargia.games.core;

import com.ilargia.games.entitas.api.*;
import com.ilargia.games.components.Score;

/**
 * ---------------------------------------------------------------------------
 * '<auto-generated>' This code was generated by CodeGeneratorApp.
 * ---------------------------------------------------------------------------
 */
public class ScoreContext
		extends
			com.ilargia.games.entitas.Context<ScoreEntity> {

	public ScoreContext(int totalComponents, int startCreationIndex,
			ContextInfo contextInfo, FactoryEntity<ScoreEntity> factoryMethod) {
		super(totalComponents, startCreationIndex, contextInfo, factoryMethod);
	}

	public ScoreEntity getScoreEntity() {
		return getGroup(ScoreMatcher.Score()).getSingleEntity();
	}

	public Score getScore() {
		return getScoreEntity().getScore();
	}

	public boolean hasScore() {
		return getScoreEntity() != null;
	}

	public ScoreEntity setScore(int value) {
		if (hasScore()) {
			throw new EntitasException(
					"Could not set Score!" + this
							+ " already has an entity with Score!",
					"You should check if the context already has a ScoreEntity before setting it or use context.ReplaceScore().");
		}
		ScoreEntity entity = createEntity();
		entity.addScore(value);
		return entity;
	}

	public ScoreEntity replaceScore(int value) {
		ScoreEntity entity = getScoreEntity();
		if (entity == null) {
			entity = setScore(value);
		} else {
			entity.replaceScore(value);
		}
		return entity;
	}

	public ScoreContext removeScore() {
		destroyEntity(getScoreEntity());
		return this;
	}
}