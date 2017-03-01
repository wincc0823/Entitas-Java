package com.indignado.games.states.game.gen.actuator;

import com.ilargia.games.entitas.api.*;
import com.ilargia.games.entitas.Entity;
import java.util.Stack;
import com.indignado.games.states.game.component.actuator.CameraActuator;
import com.ilargia.games.entitas.api.IComponent;
import com.ilargia.games.entitas.api.IEntity;
import com.indignado.games.states.game.component.actuator.CharacterActuator;
import com.badlogic.gdx.math.Vector2;
import com.indignado.games.states.game.data.StateCharacter;
import com.indignado.games.states.game.component.actuator.TextureActuator;
import com.badlogic.gdx.graphics.Color;
import com.indignado.games.states.game.data.Bounds;
import com.indignado.games.states.game.component.actuator.VelocityActuator;

/**
 * ---------------------------------------------------------------------------
 * '<auto-generated>' This code was generated by CodeGeneratorApp.
 * ---------------------------------------------------------------------------
 */
public class ActuatorEntity extends Entity {

	public ActuatorEntity() {
	}

	public CameraActuator getCameraActuator() {
		return (CameraActuator) getComponent(ActuatorComponentsLookup.CameraActuator);
	}

	public boolean hasCameraActuator() {
		return hasComponent(ActuatorComponentsLookup.CameraActuator);
	}

	public ActuatorEntity addCameraActuator(short height, float damping,
			String followTagEntity) {
		CameraActuator component = (CameraActuator) recoverComponent(ActuatorComponentsLookup.CameraActuator);
		if (component == null) {
			component = new CameraActuator();
		}
		component.height = height;
		component.damping = damping;
		component.followTagEntity = followTagEntity;
		addComponent(ActuatorComponentsLookup.CameraActuator, component);
		return this;
	}

	public ActuatorEntity replaceCameraActuator(short height, float damping,
			String followTagEntity) {
		CameraActuator component = (CameraActuator) recoverComponent(ActuatorComponentsLookup.CameraActuator);
		if (component == null) {
			component = new CameraActuator();
		}
		component.height = height;
		component.damping = damping;
		component.followTagEntity = followTagEntity;
		replaceComponent(ActuatorComponentsLookup.CameraActuator, component);
		return this;
	}

	public ActuatorEntity removeCameraActuator() {
		removeComponent(ActuatorComponentsLookup.CameraActuator);
		return this;
	}

	public CharacterActuator getCharacterActuator() {
		return (CharacterActuator) getComponent(ActuatorComponentsLookup.CharacterActuator);
	}

	public boolean hasCharacterActuator() {
		return hasComponent(ActuatorComponentsLookup.CharacterActuator);
	}

	public ActuatorEntity addCharacterActuator(String target,
			StateCharacter newState, boolean facingLeft) {
		CharacterActuator component = (CharacterActuator) recoverComponent(ActuatorComponentsLookup.CharacterActuator);
		if (component == null) {
			component = new CharacterActuator();
		}
		component.target = target;
		component.newState = newState;
		component.facingLeft = facingLeft;
		addComponent(ActuatorComponentsLookup.CharacterActuator, component);
		return this;
	}

	public ActuatorEntity replaceCharacterActuator(String target,
			StateCharacter newState, boolean facingLeft) {
		CharacterActuator component = (CharacterActuator) recoverComponent(ActuatorComponentsLookup.CharacterActuator);
		if (component == null) {
			component = new CharacterActuator();
		}
		component.target = target;
		component.newState = newState;
		component.facingLeft = facingLeft;
		replaceComponent(ActuatorComponentsLookup.CharacterActuator, component);
		return this;
	}

	public ActuatorEntity removeCharacterActuator() {
		removeComponent(ActuatorComponentsLookup.CharacterActuator);
		return this;
	}

	public TextureActuator getTextureActuator() {
		return (TextureActuator) getComponent(ActuatorComponentsLookup.TextureActuator);
	}

	public boolean hasTextureActuator() {
		return hasComponent(ActuatorComponentsLookup.TextureActuator);
	}

	public ActuatorEntity addTextureActuator(String target, Bounds bounds,
			int opacity, Boolean flipX, Boolean flipY, Color tint) {
		TextureActuator component = (TextureActuator) recoverComponent(ActuatorComponentsLookup.TextureActuator);
		if (component == null) {
			component = new TextureActuator();
		}
		component.target = target;
		component.bounds = bounds;
		component.opacity = opacity;
		component.flipX = flipX;
		component.flipY = flipY;
		component.tint = tint;
		addComponent(ActuatorComponentsLookup.TextureActuator, component);
		return this;
	}

	public ActuatorEntity replaceTextureActuator(String target, Bounds bounds,
			int opacity, Boolean flipX, Boolean flipY, Color tint) {
		TextureActuator component = (TextureActuator) recoverComponent(ActuatorComponentsLookup.TextureActuator);
		if (component == null) {
			component = new TextureActuator();
		}
		component.target = target;
		component.bounds = bounds;
		component.opacity = opacity;
		component.flipX = flipX;
		component.flipY = flipY;
		component.tint = tint;
		replaceComponent(ActuatorComponentsLookup.TextureActuator, component);
		return this;
	}

	public ActuatorEntity removeTextureActuator() {
		removeComponent(ActuatorComponentsLookup.TextureActuator);
		return this;
	}

	public VelocityActuator getVelocityActuator() {
		return (VelocityActuator) getComponent(ActuatorComponentsLookup.VelocityActuator);
	}

	public boolean hasVelocityActuator() {
		return hasComponent(ActuatorComponentsLookup.VelocityActuator);
	}

	public ActuatorEntity addVelocityActuator(String target, Vector2 velocity,
			float angularVelocity) {
		VelocityActuator component = (VelocityActuator) recoverComponent(ActuatorComponentsLookup.VelocityActuator);
		if (component == null) {
			component = new VelocityActuator();
		}
		component.target = target;
		component.velocity = velocity;
		component.angularVelocity = angularVelocity;
		addComponent(ActuatorComponentsLookup.VelocityActuator, component);
		return this;
	}

	public ActuatorEntity replaceVelocityActuator(String target,
			Vector2 velocity, float angularVelocity) {
		VelocityActuator component = (VelocityActuator) recoverComponent(ActuatorComponentsLookup.VelocityActuator);
		if (component == null) {
			component = new VelocityActuator();
		}
		component.target = target;
		component.velocity = velocity;
		component.angularVelocity = angularVelocity;
		replaceComponent(ActuatorComponentsLookup.VelocityActuator, component);
		return this;
	}

	public ActuatorEntity removeVelocityActuator() {
		removeComponent(ActuatorComponentsLookup.VelocityActuator);
		return this;
	}
}