package com.indignado.games.states.game.gen.scene;

import com.indignado.games.states.game.component.scene.Background;
import com.indignado.games.states.game.component.scene.Camera;
import com.indignado.games.states.game.component.scene.GameWorld;
import com.indignado.games.states.game.component.scene.Light;
import com.indignado.games.states.game.component.scene.Tiled;

/**
 * ---------------------------------------------------------------------------
 * '<auto-generated>' This code was generated by CodeGeneratorApp.
 * ---------------------------------------------------------------------------
 */
public class SceneComponentsLookup {

	public static final int Background = 0;
	public static final int Camera = 1;
	public static final int GameWorld = 2;
	public static final int Light = 3;
	public static final int Tiled = 4;
	public static final int totalComponents = 5;

	public static String[] componentNames() {
		return new String[]{"Background", "Camera", "GameWorld", "Light",
				"Tiled"};
	}

	public static Class[] componentTypes() {
		return new Class[]{Background.class, Camera.class, GameWorld.class,
				Light.class, Tiled.class};
	}
}