package com.ilargia.games.core.gen.game;

import com.ilargia.games.entitas.api.ContextInfo;
import com.ilargia.games.entitas.api.EntityBaseFactory;

/**
 * ---------------------------------------------------------------------------
 * '<auto-generated>' This code was generated by CodeGeneratorApp.
 * ---------------------------------------------------------------------------
 */
public class GameContext extends com.ilargia.games.entitas.Context<GameEntity> {

	public GameContext(int totalComponents, int startCreationIndex,
			ContextInfo contextInfo, EntityBaseFactory<GameEntity> factoryMethod) {
		super(totalComponents, startCreationIndex, contextInfo, factoryMethod);
	}

	public GameEntity getPlayerEntity() {
		return getGroup(GameMatcher.Player()).getSingleEntity();
	}

	public boolean isPlayer() {
		return getPlayerEntity() != null;
	}

	public GameContext setPlayer(boolean value) {
		GameEntity entity = getPlayerEntity();
		if (value != (entity != null)) {
			if (value) {
				entity.setPlayer(true);
			} else {
				destroyEntity(entity);
			}
		}
		return this;
	}
}