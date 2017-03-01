package com.ilargia.games.core.component.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.ilargia.games.entitas.api.IComponent;
import com.ilargia.games.entitas.codeGenerator.Component;
import com.ilargia.games.core.data.Bounds;

@Component(pools = {"Game"})
public class TextureView implements IComponent {
    public TextureRegion texture;
    public Bounds bounds;
    public boolean flipX;
    public boolean flipY;
    public int opacity;
    public int layer;
    public Color tint;

    public TextureView(TextureRegion texture, Bounds bounds, boolean flipX, boolean flipY,
                       int opacity, int layer, Color tint) {
        this.texture = texture;
        this.bounds = bounds;
        this.flipX = flipX;
        this.flipY = flipY;
        this.opacity = opacity;
        this.layer = layer;
        this.tint = tint;
    }
}
