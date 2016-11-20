package com.ilargia.games.core;

import com.ilargia.games.components.Identity;
import com.ilargia.games.components.Score;
import com.ilargia.games.components.Bounds;
import com.ilargia.games.components.View;
import com.ilargia.games.components.Motion;

/**
 * ---------------------------------------------------------------------------
 * '<auto-generated>' This code was generated by CodeGeneratorApp. Changes to
 * this file may cause incorrect behavior and will be lost.
 * 
 * ---------------------------------------------------------------------------
 */
public class CoreComponentIds {

	public static final int Identity = 0;
	public static final int Score = 1;
	public static final int Bounds = 2;
	public static final int View = 3;
	public static final int Motion = 4;
	public static final int totalComponents = 5;

	public static String[] componentNames() {
		return new String[]{"Identity", "Score", "Bounds", "View", "Motion"};
	}

	public static Class[] componentTypes() {
		return new Class[]{Identity.class, Score.class, Bounds.class,
				View.class, Motion.class};
	}
}