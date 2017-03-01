package com.ilargia.games.core.gen.scene;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.ilargia.games.entitas.Entity;
import com.ilargia.games.states.game.component.scene.*;

/**
 * ---------------------------------------------------------------------------
 * '<auto-generated>' This code was generated by CodeGeneratorApp.
 * ---------------------------------------------------------------------------
 */
public class SceneEntity extends Entity {

	public SceneEntity() {
	}

	public Background getBackground() {
		return (Background) getComponent(SceneComponentsLookup.Background);
	}

	public boolean hasBackground() {
		return hasComponent(SceneComponentsLookup.Background);
	}

	public SceneEntity addBackground(Texture front, Texture middle, Texture back) {
		Background component = (Background) recoverComponent(SceneComponentsLookup.Background);
		if (component == null) {
			component = new Background();
		}
		component.front = front;
		component.middle = middle;
		component.back = back;
		addComponent(SceneComponentsLookup.Background, component);
		return this;
	}

	public SceneEntity replaceBackground(Texture front, Texture middle,
                                         Texture back) {
		Background component = (Background) recoverComponent(SceneComponentsLookup.Background);
		if (component == null) {
			component = new Background();
		}
		component.front = front;
		component.middle = middle;
		component.back = back;
		replaceComponent(SceneComponentsLookup.Background, component);
		return this;
	}

	public SceneEntity removeBackground() {
		removeComponent(SceneComponentsLookup.Background);
		return this;
	}

	public Camera getCamera() {
		return (Camera) getComponent(SceneComponentsLookup.Camera);
	}

	public boolean hasCamera() {
		return hasComponent(SceneComponentsLookup.Camera);
	}

	public SceneEntity addCamera(OrthographicCamera camera) {
		Camera component = (Camera) recoverComponent(SceneComponentsLookup.Camera);
		if (component == null) {
			component = new Camera();
		}
		component.camera = camera;
		addComponent(SceneComponentsLookup.Camera, component);
		return this;
	}

	public SceneEntity replaceCamera(OrthographicCamera camera) {
		Camera component = (Camera) recoverComponent(SceneComponentsLookup.Camera);
		if (component == null) {
			component = new Camera();
		}
		component.camera = camera;
		replaceComponent(SceneComponentsLookup.Camera, component);
		return this;
	}

	public SceneEntity removeCamera() {
		removeComponent(SceneComponentsLookup.Camera);
		return this;
	}

	public GameWorld getGameWorld() {
		return (GameWorld) getComponent(SceneComponentsLookup.GameWorld);
	}

	public boolean hasGameWorld() {
		return hasComponent(SceneComponentsLookup.GameWorld);
	}

	public SceneEntity addGameWorld(float width, float height,
                                    float metresToPixels, float pixelsToMetres, boolean catchBack,
                                    boolean catchMenu, Color backGroundColor) {
		GameWorld component = (GameWorld) recoverComponent(SceneComponentsLookup.GameWorld);
		if (component == null) {
			component = new GameWorld();
		}
		component.width = width;
		component.height = height;
		component.metresToPixels = metresToPixels;
		component.pixelsToMetres = pixelsToMetres;
		component.catchBack = catchBack;
		component.catchMenu = catchMenu;
		component.backGroundColor = backGroundColor;
		addComponent(SceneComponentsLookup.GameWorld, component);
		return this;
	}

	public SceneEntity replaceGameWorld(float width, float height,
                                        float metresToPixels, float pixelsToMetres, boolean catchBack,
                                        boolean catchMenu, Color backGroundColor) {
		GameWorld component = (GameWorld) recoverComponent(SceneComponentsLookup.GameWorld);
		if (component == null) {
			component = new GameWorld();
		}
		component.width = width;
		component.height = height;
		component.metresToPixels = metresToPixels;
		component.pixelsToMetres = pixelsToMetres;
		component.catchBack = catchBack;
		component.catchMenu = catchMenu;
		component.backGroundColor = backGroundColor;
		replaceComponent(SceneComponentsLookup.GameWorld, component);
		return this;
	}

	public SceneEntity removeGameWorld() {
		removeComponent(SceneComponentsLookup.GameWorld);
		return this;
	}

	public Light getLight() {
		return (Light) getComponent(SceneComponentsLookup.Light);
	}

	public boolean hasLight() {
		return hasComponent(SceneComponentsLookup.Light);
	}

	public SceneEntity addLight(box2dLight.Light light) {
		Light component = (Light) recoverComponent(SceneComponentsLookup.Light);
		if (component == null) {
			component = new Light();
		}
		component.light = light;
		addComponent(SceneComponentsLookup.Light, component);
		return this;
	}

	public SceneEntity replaceLight(box2dLight.Light light) {
		Light component = (Light) recoverComponent(SceneComponentsLookup.Light);
		if (component == null) {
			component = new Light();
		}
		component.light = light;
		replaceComponent(SceneComponentsLookup.Light, component);
		return this;
	}

	public SceneEntity removeLight() {
		removeComponent(SceneComponentsLookup.Light);
		return this;
	}

	public Tiled getTiled() {
		return (Tiled) getComponent(SceneComponentsLookup.Tiled);
	}

	public boolean hasTiled() {
		return hasComponent(SceneComponentsLookup.Tiled);
	}

	public SceneEntity addTiled(String tileMapName, float unitScale) {
		Tiled component = (Tiled) recoverComponent(SceneComponentsLookup.Tiled);
		if (component == null) {
			component = new Tiled();
		}
		component.tileMapName = tileMapName;
		component.unitScale = unitScale;
		addComponent(SceneComponentsLookup.Tiled, component);
		return this;
	}

	public SceneEntity replaceTiled(String tileMapName, float unitScale) {
		Tiled component = (Tiled) recoverComponent(SceneComponentsLookup.Tiled);
		if (component == null) {
			component = new Tiled();
		}
		component.tileMapName = tileMapName;
		component.unitScale = unitScale;
		replaceComponent(SceneComponentsLookup.Tiled, component);
		return this;
	}

	public SceneEntity removeTiled() {
		removeComponent(SceneComponentsLookup.Tiled);
		return this;
	}
}