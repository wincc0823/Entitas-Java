package com.ilargia.games.logicbrick.gen.input;

import com.ilargia.games.entitas.api.*;
import com.ilargia.games.entitas.Entity;
import java.util.Stack;
import com.ilargia.games.logicbrick.component.input.PadButtons;
import com.ilargia.games.entitas.api.IComponent;
import com.ilargia.games.logicbrick.component.input.PlayerInputController;
import com.ilargia.games.logicbrick.component.input.TouchPad;

/**
 * ---------------------------------------------------------------------------
 * '<auto-generated>' This code was generated by CodeGeneratorApp.
 * ---------------------------------------------------------------------------
 */
public class InputEntity extends Entity {

	public PadButtons PadButtonsComponent = new PadButtons();
	public TouchPad TouchPadComponent = new TouchPad();

	public InputEntity() {
	}

	public boolean isPadButtons() {
		return hasComponent(InputComponentsLookup.PadButtons);
	}

	public InputEntity setPadButtons(boolean value) {
		if (value != hasComponent(InputComponentsLookup.PadButtons)) {
			if (value) {
				addComponent(InputComponentsLookup.PadButtons,
						PadButtonsComponent);
			} else {
				removeComponent(InputComponentsLookup.PadButtons);
			}
		}
		return this;
	}

	public PlayerInputController getPlayerInputController() {
		return (PlayerInputController) getComponent(InputComponentsLookup.PlayerInputController);
	}

	public boolean hasPlayerInputController() {
		return hasComponent(InputComponentsLookup.PlayerInputController);
	}

	public InputEntity addPlayerInputController(boolean leftPressed,
			boolean rightPressed, boolean jumpPressed) {
		PlayerInputController component = (PlayerInputController) recoverComponent(InputComponentsLookup.PlayerInputController);
		if (component == null) {
			component = new PlayerInputController();
		}
		component.leftPressed = leftPressed;
		component.rightPressed = rightPressed;
		component.jumpPressed = jumpPressed;
		addComponent(InputComponentsLookup.PlayerInputController, component);
		return this;
	}

	public InputEntity replacePlayerInputController(boolean leftPressed,
			boolean rightPressed, boolean jumpPressed) {
		PlayerInputController component = (PlayerInputController) recoverComponent(InputComponentsLookup.PlayerInputController);
		if (component == null) {
			component = new PlayerInputController();
		}
		component.leftPressed = leftPressed;
		component.rightPressed = rightPressed;
		component.jumpPressed = jumpPressed;
		replaceComponent(InputComponentsLookup.PlayerInputController, component);
		return this;
	}

	public InputEntity removePlayerInputController() {
		removeComponent(InputComponentsLookup.PlayerInputController);
		return this;
	}

	public boolean isTouchPad() {
		return hasComponent(InputComponentsLookup.TouchPad);
	}

	public InputEntity setTouchPad(boolean value) {
		if (value != hasComponent(InputComponentsLookup.TouchPad)) {
			if (value) {
				addComponent(InputComponentsLookup.TouchPad, TouchPadComponent);
			} else {
				removeComponent(InputComponentsLookup.TouchPad);
			}
		}
		return this;
	}
}