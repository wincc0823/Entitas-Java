package com.indignado.games.states.game.gen.game;

import com.ilargia.games.entitas.api.*;
import com.ilargia.games.entitas.Entity;
import java.util.Stack;
import com.indignado.games.states.game.component.game.Animations;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.ilargia.games.entitas.api.IComponent;
import java.util.Map;
import com.indignado.games.states.game.component.game.Character;
import com.indignado.games.states.game.data.StateCharacter;
import com.indignado.games.states.game.component.game.Destroy;
import com.indignado.games.states.game.component.game.Element;
import com.indignado.games.states.game.component.game.Interactive;
import com.indignado.games.states.game.component.game.Movable;
import com.indignado.games.states.game.component.game.OnGround;
import com.indignado.games.states.game.component.game.Player;
import com.indignado.games.states.game.component.game.RigidBody;
import com.badlogic.gdx.physics.box2d.Body;
import com.indignado.games.states.game.component.game.TextureView;
import com.badlogic.gdx.graphics.Color;
import com.indignado.games.states.game.data.Bounds;

/**
 * ---------------------------------------------------------------------------
 * '<auto-generated>' This code was generated by CodeGeneratorApp.
 * ---------------------------------------------------------------------------
 */
public class GameEntity extends Entity {

	public Destroy DestroyComponent = new Destroy();
	public Interactive InteractiveComponent = new Interactive();
	public OnGround OnGroundComponent = new OnGround();
	public Player PlayerComponent = new Player();

	public GameEntity() {
	}

	public Animations getAnimations() {
		return (Animations) getComponent(GameComponentsLookup.Animations);
	}

	public boolean hasAnimations() {
		return hasComponent(GameComponentsLookup.Animations);
	}

	public GameEntity addAnimations(
			Map<String, Animation<TextureRegion>> animationStates,
			Animation<TextureRegion> currentAnimation, float time) {
		Animations component = (Animations) recoverComponent(GameComponentsLookup.Animations);
		if (component == null) {
			component = new Animations();
		}
		component.animationStates = animationStates;
		component.currentAnimation = currentAnimation;
		component.time = time;
		addComponent(GameComponentsLookup.Animations, component);
		return this;
	}

	public GameEntity replaceAnimations(
			Map<String, Animation<TextureRegion>> animationStates,
			Animation<TextureRegion> currentAnimation, float time) {
		Animations component = (Animations) recoverComponent(GameComponentsLookup.Animations);
		if (component == null) {
			component = new Animations();
		}
		component.animationStates = animationStates;
		component.currentAnimation = currentAnimation;
		component.time = time;
		replaceComponent(GameComponentsLookup.Animations, component);
		return this;
	}

	public GameEntity removeAnimations() {
		removeComponent(GameComponentsLookup.Animations);
		return this;
	}

	public Character getCharacter() {
		return (Character) getComponent(GameComponentsLookup.Character);
	}

	public boolean hasCharacter() {
		return hasComponent(GameComponentsLookup.Character);
	}

	public GameEntity addCharacter(String tag, StateCharacter currentState,
			boolean facingLeft) {
		Character component = (Character) recoverComponent(GameComponentsLookup.Character);
		if (component == null) {
			component = new Character();
		}
		component.tag = tag;
		component.currentState = currentState;
		component.facingLeft = facingLeft;
		addComponent(GameComponentsLookup.Character, component);
		return this;
	}

	public GameEntity replaceCharacter(String tag, StateCharacter currentState,
			boolean facingLeft) {
		Character component = (Character) recoverComponent(GameComponentsLookup.Character);
		if (component == null) {
			component = new Character();
		}
		component.tag = tag;
		component.currentState = currentState;
		component.facingLeft = facingLeft;
		replaceComponent(GameComponentsLookup.Character, component);
		return this;
	}

	public GameEntity removeCharacter() {
		removeComponent(GameComponentsLookup.Character);
		return this;
	}

	public boolean isDestroy() {
		return hasComponent(GameComponentsLookup.Destroy);
	}

	public GameEntity setDestroy(boolean value) {
		if (value != hasComponent(GameComponentsLookup.Destroy)) {
			if (value) {
				addComponent(GameComponentsLookup.Destroy, DestroyComponent);
			} else {
				removeComponent(GameComponentsLookup.Destroy);
			}
		}
		return this;
	}

	public Element getElement() {
		return (Element) getComponent(GameComponentsLookup.Element);
	}

	public boolean hasElement() {
		return hasComponent(GameComponentsLookup.Element);
	}

	public GameEntity addElement(String type, String tags) {
		Element component = (Element) recoverComponent(GameComponentsLookup.Element);
		if (component == null) {
			component = new Element();
		}
		component.type = type;
		component.tags = tags;
		addComponent(GameComponentsLookup.Element, component);
		return this;
	}

	public GameEntity replaceElement(String type, String tags) {
		Element component = (Element) recoverComponent(GameComponentsLookup.Element);
		if (component == null) {
			component = new Element();
		}
		component.type = type;
		component.tags = tags;
		replaceComponent(GameComponentsLookup.Element, component);
		return this;
	}

	public GameEntity removeElement() {
		removeComponent(GameComponentsLookup.Element);
		return this;
	}

	public boolean isInteractive() {
		return hasComponent(GameComponentsLookup.Interactive);
	}

	public GameEntity setInteractive(boolean value) {
		if (value != hasComponent(GameComponentsLookup.Interactive)) {
			if (value) {
				addComponent(GameComponentsLookup.Interactive,
						InteractiveComponent);
			} else {
				removeComponent(GameComponentsLookup.Interactive);
			}
		}
		return this;
	}

	public Movable getMovable() {
		return (Movable) getComponent(GameComponentsLookup.Movable);
	}

	public boolean hasMovable() {
		return hasComponent(GameComponentsLookup.Movable);
	}

	public GameEntity addMovable(float maxVelocity, float jumpForce) {
		Movable component = (Movable) recoverComponent(GameComponentsLookup.Movable);
		if (component == null) {
			component = new Movable();
		}
		component.maxVelocity = maxVelocity;
		component.jumpForce = jumpForce;
		addComponent(GameComponentsLookup.Movable, component);
		return this;
	}

	public GameEntity replaceMovable(float maxVelocity, float jumpForce) {
		Movable component = (Movable) recoverComponent(GameComponentsLookup.Movable);
		if (component == null) {
			component = new Movable();
		}
		component.maxVelocity = maxVelocity;
		component.jumpForce = jumpForce;
		replaceComponent(GameComponentsLookup.Movable, component);
		return this;
	}

	public GameEntity removeMovable() {
		removeComponent(GameComponentsLookup.Movable);
		return this;
	}

	public boolean isOnGround() {
		return hasComponent(GameComponentsLookup.OnGround);
	}

	public GameEntity setOnGround(boolean value) {
		if (value != hasComponent(GameComponentsLookup.OnGround)) {
			if (value) {
				addComponent(GameComponentsLookup.OnGround, OnGroundComponent);
			} else {
				removeComponent(GameComponentsLookup.OnGround);
			}
		}
		return this;
	}

	public boolean isPlayer() {
		return hasComponent(GameComponentsLookup.Player);
	}

	public GameEntity setPlayer(boolean value) {
		if (value != hasComponent(GameComponentsLookup.Player)) {
			if (value) {
				addComponent(GameComponentsLookup.Player, PlayerComponent);
			} else {
				removeComponent(GameComponentsLookup.Player);
			}
		}
		return this;
	}

	public RigidBody getRigidBody() {
		return (RigidBody) getComponent(GameComponentsLookup.RigidBody);
	}

	public boolean hasRigidBody() {
		return hasComponent(GameComponentsLookup.RigidBody);
	}

	public GameEntity addRigidBody(Body body) {
		RigidBody component = (RigidBody) recoverComponent(GameComponentsLookup.RigidBody);
		if (component == null) {
			component = new RigidBody();
		}
		component.body = body;
		addComponent(GameComponentsLookup.RigidBody, component);
		return this;
	}

	public GameEntity replaceRigidBody(Body body) {
		RigidBody component = (RigidBody) recoverComponent(GameComponentsLookup.RigidBody);
		if (component == null) {
			component = new RigidBody();
		}
		component.body = body;
		replaceComponent(GameComponentsLookup.RigidBody, component);
		return this;
	}

	public GameEntity removeRigidBody() {
		removeComponent(GameComponentsLookup.RigidBody);
		return this;
	}

	public TextureView getTextureView() {
		return (TextureView) getComponent(GameComponentsLookup.TextureView);
	}

	public boolean hasTextureView() {
		return hasComponent(GameComponentsLookup.TextureView);
	}

	public GameEntity addTextureView(TextureRegion texture, Bounds bounds,
			boolean flipX, boolean flipY, int opacity, int layer, Color tint) {
		TextureView component = (TextureView) recoverComponent(GameComponentsLookup.TextureView);
		if (component == null) {
			component = new TextureView(texture, bounds, flipX, flipY, opacity,
					layer, tint);
		} else {
			component.texture = texture;;
			component.bounds = bounds;;
			component.flipX = flipX;;
			component.flipY = flipY;;
			component.opacity = opacity;;
			component.layer = layer;;
			component.tint = tint;
		}
		addComponent(GameComponentsLookup.TextureView, component);
		return this;
	}

	public GameEntity replaceTextureView(TextureRegion texture, Bounds bounds,
			boolean flipX, boolean flipY, int opacity, int layer, Color tint) {
		TextureView component = (TextureView) recoverComponent(GameComponentsLookup.TextureView);
		if (component == null) {
			component = new TextureView(texture, bounds, flipX, flipY, opacity,
					layer, tint);
		} else {
			component.texture = texture;;
			component.bounds = bounds;;
			component.flipX = flipX;;
			component.flipY = flipY;;
			component.opacity = opacity;;
			component.layer = layer;;
			component.tint = tint;
		}
		replaceComponent(GameComponentsLookup.TextureView, component);
		return this;
	}

	public GameEntity removeTextureView() {
		removeComponent(GameComponentsLookup.TextureView);
		return this;
	}
}