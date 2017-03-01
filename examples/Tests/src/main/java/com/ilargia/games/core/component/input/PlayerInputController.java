package com.ilargia.games.core.component.input;

import com.ilargia.games.entitas.api.IComponent;
import com.ilargia.games.entitas.codeGenerator.Component;

@Component(pools = {"Input"}, isSingleEntity = true)
public class PlayerInputController implements IComponent {
    public boolean leftPressed = false;
    public boolean rightPressed = false;
    public boolean jumpPressed = false;


}
