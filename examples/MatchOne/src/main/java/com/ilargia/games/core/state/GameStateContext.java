package com.ilargia.games.core.state;

import com.ilargia.games.entitas.api.*;
import com.ilargia.games.core.component.state.Score;

/**
 * ---------------------------------------------------------------------------
 * '<auto-generated>' This code was generated by CodeGeneratorApp.
 * ---------------------------------------------------------------------------
 */
public class GameStateContext
		extends
			com.ilargia.games.entitas.Context<GameStateEntity> {

	public GameStateContext(int totalComponents, int startCreationIndex,
			ContextInfo contextInfo,
			EntityBaseFactory<GameStateEntity> factoryMethod) {
		super(totalComponents, startCreationIndex, contextInfo, factoryMethod);
	}

	public GameStateEntity getScoreEntity() {
		return getGroup(GamestateMatcher.Score()).getSingleEntity();
	}

	public Score getScore() {
		return getScoreEntity().getScore();
	}

	public boolean hasScore() {
		return getScoreEntity() != null;
	}

	public GameStateEntity setScore(int value) {
		if (hasScore()) {
			throw new EntitasException(
					"Could not set Score!" + this
							+ " already has an entity with Score!",
					"You should check if the context already has a ScoreEntity before setting it or use context.ReplaceScore().");
		}
		GameStateEntity entity = createEntity();
		entity.addScore(value);
		return entity;
	}

	public GameStateEntity replaceScore(int value) {
		GameStateEntity entity = getScoreEntity();
		if (entity == null) {
			entity = setScore(value);
		} else {
			entity.replaceScore(value);
		}
		return entity;
	}

	public GameStateContext removeScore() {
		destroyEntity(getScoreEntity());
		return this;
	}
}