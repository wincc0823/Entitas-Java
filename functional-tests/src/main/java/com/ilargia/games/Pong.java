package com.ilargia.games;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.ilargia.games.core.Pool;
import com.ilargia.games.core.Pools;
import com.ilargia.games.entitas.Systems;
import com.ilargia.games.systems.*;


public class Pong extends ApplicationAdapter {
    private Pools pools;
    private Systems systems;

    public static void main (String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "BASIC";
        config.width = 800;
        config.height = 480;
        new LwjglApplication(new Pong(), config);
    }

    @Override
    public void create() {
        pools =  new Pools();
        ShapeRenderer sr = new ShapeRenderer();
        OrthographicCamera cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        systems = new Systems()
                .add(Pool.createSystem(pools.core,new InputSystem()))
                .add(Pool.createSystem(pools.core,new ContactSystem()))
                .add(Pool.createSystem(pools.core,new BoundsSystem()))
                .add(Pool.createSystem(pools.core,new MoveSystem()))
                .add(Pool.createSystem(pools.core,new RendererSystem(sr, cam)));



    }

    @Override
    public void render() {
        systems.execute();
    }

    @Override
    public void dispose() {


    }
}