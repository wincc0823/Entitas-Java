package com.ilargia.games.egdx.logicbricks.index;

import com.ilargia.games.egdx.logicbricks.gen.Entitas;
import com.ilargia.games.egdx.logicbricks.gen.actuator.ActuatorEntity;
import com.ilargia.games.egdx.logicbricks.gen.actuator.ActuatorMatcher;
import com.ilargia.games.egdx.logicbricks.gen.sensor.SensorMatcher;
import com.ilargia.games.entitas.index.EntityIndex;
import com.ilargia.games.egdx.logicbricks.gen.game.GameEntity;
import com.ilargia.games.egdx.logicbricks.gen.game.GameMatcher;
import com.ilargia.games.egdx.logicbricks.gen.sensor.SensorEntity;
import com.ilargia.games.entitas.index.ReactiveEntityIndex;
import com.ilargia.games.entitas.index.ReactivePrimaryEntityIndex;
import com.ilargia.games.entitas.matcher.Matcher;

import java.util.Set;

public class Indexed {
    public static final String GameEntitiesInSensorIndex = "GameEntitiesInSensorIndex";
    public static final String SensorsEntitiesIndex = "SensorsEntitiesIndex";
    public static final String ActuatorsEntitiesIndex = "ActuatorsEntitiesIndex";
    public static final String InteractiveEntityIndex = "InteractiveEntityIndex";
    public static final String TagEntityIndex = "TagEntityIndex";

    private static Entitas _entitas;
    private static KeyIndex index;


    public static void initialize(Entitas entitas) {
        _entitas = entitas;
         index = new KeyIndex(-1,null);
        // GameEntity contains Sensors entities
        _entitas.sensor.addEntityIndex(Indexed.SensorsEntitiesIndex,  new ReactivePrimaryEntityIndex<SensorEntity, KeyIndex>(
                ((e, c) -> new KeyIndex(e.getLink().ownerEntity,e.getLink().nameReference)), _entitas.sensor.getGroup(SensorMatcher.Link())));

        // GameEntity contains Actuator entities
        _entitas.actuator.addEntityIndex(Indexed.ActuatorsEntitiesIndex,  new ReactiveEntityIndex<ActuatorEntity, KeyIndex>(
                ((e, c) -> new KeyIndex(e.getLink().ownerEntity,e.getLink().nameReference)), _entitas.actuator.getGroup(ActuatorMatcher.Link())));

        // Interactive GameEntity index
        _entitas.game.addEntityIndex(Indexed.InteractiveEntityIndex,  new ReactivePrimaryEntityIndex<GameEntity, Integer>(
                ((e, c) -> e.getCreationIndex()), _entitas.game.getGroup(GameMatcher.Interactive())));

        // Tags GameEntity index
        _entitas.game.addEntityIndex(Indexed.TagEntityIndex, new ReactivePrimaryEntityIndex<GameEntity, String>(
                _entitas.game.getGroup(Matcher.AllOf(GameMatcher.Tags(),GameMatcher.Interactive())),
                ((e, c) -> e.getTags().values.toArray(new String[0]))));

        // Sensors context GameEntities
        _entitas.game.addEntityIndex(Indexed.GameEntitiesInSensorIndex, new EntityIndex<GameEntity, Integer>());


    }


    public static Set<GameEntity> getEntitiesInSensor(SensorEntity entity) {
        EntityIndex<GameEntity, Integer> eIndex = (EntityIndex<GameEntity, Integer>) _entitas.game.getEntityIndex(GameEntitiesInSensorIndex);
        return eIndex.getEntities(entity.getCreationIndex());
    }

    public static void addEntityInSensor(SensorEntity entity, GameEntity gameEntity) {
        EntityIndex<GameEntity, Integer> eIndex = (EntityIndex<GameEntity, Integer>) _entitas.game.getEntityIndex(GameEntitiesInSensorIndex);
        eIndex.addEntity(entity.getCreationIndex(), gameEntity);
    }

    public static void removeEntityInSensor(SensorEntity entity, GameEntity gameEntity) {
        EntityIndex<GameEntity, Integer> eIndex = (EntityIndex<GameEntity, Integer>) _entitas.game.getEntityIndex(GameEntitiesInSensorIndex);
        eIndex.removeEntity(entity.getCreationIndex(), gameEntity);
    }

    public static SensorEntity getSensorsEntity(GameEntity entity, String nameSensor) {
       return getSensorsEntity(entity.getCreationIndex(),nameSensor);
    }

    public static SensorEntity getSensorsEntity(int indexGameEntity, String nameSensor) {
        ReactivePrimaryEntityIndex<SensorEntity, KeyIndex> eIndex = (ReactivePrimaryEntityIndex<SensorEntity, KeyIndex>) _entitas.sensor.getEntityIndex(SensorsEntitiesIndex);
        return eIndex.getEntity(index.setIndex(indexGameEntity,nameSensor));
    }

    public static ActuatorEntity getActuatorEntity( GameEntity entity, String nameSensor) {
        return getActuatorEntity(entity.getCreationIndex(),nameSensor);
    }

    public static ActuatorEntity getActuatorEntity( int indexGameEntity, String nameSensor) {
        ReactivePrimaryEntityIndex<ActuatorEntity, KeyIndex> eIndex = (ReactivePrimaryEntityIndex<ActuatorEntity, KeyIndex>) _entitas.sensor.getEntityIndex(ActuatorsEntitiesIndex);
        return eIndex.getEntity(index.setIndex(indexGameEntity,nameSensor));
    }

    public static GameEntity getInteractiveEntity(Integer indexEntity) {
        ReactivePrimaryEntityIndex<GameEntity, Integer> eIndex = (ReactivePrimaryEntityIndex<GameEntity, Integer>) _entitas.game.getEntityIndex(InteractiveEntityIndex);
        return eIndex.getEntity(indexEntity);
    }

    public static GameEntity getTagEntity(String tag) {
        ReactivePrimaryEntityIndex<GameEntity, String> eIndex = (ReactivePrimaryEntityIndex<GameEntity, String>) _entitas.game.getEntityIndex(TagEntityIndex);
        return eIndex.getEntity(tag);
    }


}
