package com.ilargia.games.logicbrick.system.sensor;


import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.ilargia.games.egdx.api.Engine;
import com.ilargia.games.egdx.base.managers.BasePhysicsManager;
import com.ilargia.games.egdx.base.util.BodyBuilder;
import com.ilargia.games.entitas.api.IContext;
import com.ilargia.games.entitas.collector.Collector;
import com.ilargia.games.entitas.systems.ReactiveSystem;
import com.ilargia.games.logicbrick.component.game.RigidBody;
import com.ilargia.games.logicbrick.component.sensor.RadarSensor;
import com.ilargia.games.logicbrick.gen.Entitas;
import com.ilargia.games.logicbrick.gen.game.GameContext;
import com.ilargia.games.logicbrick.gen.game.GameEntity;
import com.ilargia.games.logicbrick.gen.sensor.SensorEntity;
import com.ilargia.games.logicbrick.gen.sensor.SensorMatcher;
import com.ilargia.games.logicbrick.index.SimpleGameIndex;

import java.util.List;

public class CreateRadarSensorSystem extends ReactiveSystem<SensorEntity> {
    private final GameContext gameContext;
    private final BodyBuilder bodyBuilder;

    public CreateRadarSensorSystem(Entitas entitas, Engine engine) {
        super(entitas.sensor);
        this.gameContext = entitas.game;
        this.bodyBuilder = engine.getManager(BasePhysicsManager.class).getBodyBuilder();
    }

    @Override
    protected Collector getTrigger(IContext context) {
        return context.createCollector(SensorMatcher.RadarSensor());
    }

    @Override
    protected boolean filter(SensorEntity entity) {
        return entity.hasRadarSensor();
    }

    @Override
    protected void execute(List<SensorEntity> entities) {
        Vector2[] vertices = new Vector2[8];
        vertices[0] = new Vector2();

        for (SensorEntity e : entities) {
            GameEntity gameEntity = SimpleGameIndex.getGameEntity(gameContext, e.getLink().targetEntity);
            RigidBody rigidBody = gameEntity.getRigidBody();
            RadarSensor radarSensor = e.getRadarSensor();

            if (radarSensor.angle < 180) {
                for (int i = 0; i < 7; i++) {
                    float angle = (float) (i / 6.0 * radarSensor.angle) - (radarSensor.angle / 2) + (radarSensor.axis2D.ordinal() * 90);

                    vertices[i + 1] = new Vector2(radarSensor.distance * MathUtils.cosDeg(angle), radarSensor.distance * MathUtils.sinDeg(angle));
                }
                FixtureDef radarFixture = bodyBuilder.fixtureDefBuilder()
                        .polygonShape(vertices)
                        .sensor()
                        .build();
                rigidBody.body.createFixture(radarFixture).setUserData("RadarSensor");

            }
        }

    }

}
