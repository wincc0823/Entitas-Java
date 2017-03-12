package com.ilargia.games.entitas.system;


import com.ilargia.games.entitas.factories.CollectionsFactories;
import com.ilargia.games.entitas.factories.EntitasCollections;
import com.ilargia.games.entitas.index.EntityIndex;
import com.ilargia.games.logicbrick.component.sensor.Link;
import com.ilargia.games.logicbrick.component.sensor.NearSensor;
import com.ilargia.games.logicbrick.gen.Entitas;
import com.ilargia.games.logicbrick.gen.game.GameEntity;
import com.ilargia.games.logicbrick.gen.sensor.SensorEntity;
import com.ilargia.games.logicbrick.index.SimpleGameIndex;
import com.ilargia.games.logicbrick.system.sensor.CollisionSensorSystem;
import com.ilargia.games.logicbrick.system.sensor.IndexingLinkSensorSystem;
import com.ilargia.games.logicbrick.system.sensor.NearSensorSystem;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NearSensorSystemTest {

    Entitas entitas;
    private EntitasCollections collections;
    private NearSensorSystem nearSensorSystem;
    private IndexingLinkSensorSystem linkSensorSystem;
    EntityIndex<SensorEntity, Integer> sensorsIndex;
    EntityIndex<GameEntity, Integer> gameIndex;
    private SensorEntity sensorEntity;
    private SensorEntity sensorEntity2;
    private GameEntity boss;
    private GameEntity groundEntity;
    private GameEntity playerEntity;
    private SensorEntity sensorEntity3;
    private SensorEntity sensorEntity4;


    public NearSensorSystemTest() {
        collections = new EntitasCollections(new CollectionsFactories() {});
        entitas = new Entitas();
        this.nearSensorSystem = new NearSensorSystem(entitas);
        this.linkSensorSystem = new IndexingLinkSensorSystem(entitas);
        SimpleGameIndex.createGameEntityIndices(entitas.game);
        linkSensorSystem.activate();

        boss = entitas.game.createEntity()
                .addIdentity("Enemy","Boss");

        groundEntity = entitas.game.createEntity()
                .addIdentity("Ground","Ground");

        playerEntity = entitas.game.createEntity()
                .addIdentity("Player","Player1");

        sensorEntity = entitas.sensor.createEntity()
                .addNearSensor("Boss", 1, 1)
                .addLink(playerEntity.getCreationIndex());

        sensorEntity2 = entitas.sensor.createEntity()
                .addNearSensor("Ground", 1, 1)
                .addLink(playerEntity.getCreationIndex());

        sensorEntity3 = entitas.sensor.createEntity()
                .addCollisionSensor("Ground")
                .addLink(boss.getCreationIndex());

        sensorEntity4 = entitas.sensor.createEntity()
                .addCollisionSensor("Player")
                .addLink(boss.getCreationIndex());


        linkSensorSystem.execute(1);
        sensorsIndex = (EntityIndex<SensorEntity, Integer>)entitas.sensor.getEntityIndex("Sensors");
        gameIndex = (EntityIndex<GameEntity, Integer>) entitas.game.getEntityIndex("GameEntities");

    }


    @Test
    public void nearSensorTest() {

        nearSensorSystem.processSensorCollision(playerEntity.getCreationIndex(), boss.getCreationIndex(),"NearSensor", true);
        nearSensorSystem.execute( 0.5F);
        Link link = sensorEntity.getLink();
        NearSensor nearSensor = sensorEntity.getNearSensor();

        assertTrue(link.pulse);
        assertTrue(link.isOpen);
        assertTrue(link.isChanged);

        assertEquals(2, sensorsIndex.getEntities(playerEntity.getCreationIndex()).size());
        assertEquals( 1, nearSensor.distanceContactList.size());
        assertTrue( nearSensor.distanceContactList.contains(boss.getCreationIndex()));

        nearSensorSystem.execute( 0.5F);
        assertTrue(link.pulse);
        assertFalse(link.isOpen);
        assertFalse(link.isChanged);

        assertEquals(2, sensorsIndex.getEntities(playerEntity.getCreationIndex()).size());
        assertEquals( 1, nearSensor.distanceContactList.size());
        assertTrue( nearSensor.distanceContactList.contains(boss.getCreationIndex()));


        nearSensorSystem.processSensorCollision(playerEntity.getCreationIndex(), boss.getCreationIndex(), "NearSensor",false);
        nearSensorSystem.execute( 0.5F);
        assertFalse(link.pulse);
        assertTrue(link.isOpen);
        assertTrue(link.isChanged);

        linkSensorSystem.execute(1);


        assertEquals(2, sensorsIndex.getEntities(playerEntity.getCreationIndex()).size());
        assertEquals( 0, nearSensor.distanceContactList.size());

        nearSensorSystem.execute( 0.5F);
        assertFalse(link.pulse);
        assertFalse(link.isOpen);
        assertFalse(link.isChanged);

        nearSensorSystem.processSensorCollision(playerEntity.getCreationIndex(), groundEntity.getCreationIndex(), "NearSensor",true);
        nearSensorSystem.execute( 0.5F);
        assertFalse(link.pulse);
        assertFalse(link.isOpen);
        assertFalse(link.isChanged);
        assertEquals(2, sensorsIndex.getEntities(playerEntity.getCreationIndex()).size());
        assertEquals(0, nearSensor.distanceContactList.size());

        nearSensorSystem.execute( 0.5F);
        assertFalse(link.pulse);
        assertFalse(link.isOpen);
        assertFalse(link.isChanged);


    }

    @Test
    public void resetNearSensorTest() {

        nearSensorSystem.processSensorCollision(playerEntity.getCreationIndex(), boss.getCreationIndex(),"NearSensor", true);
        nearSensorSystem.execute( 0.5F);
        Link link = sensorEntity.getLink();
        NearSensor nearSensor = sensorEntity.getNearSensor();

        assertTrue(link.pulse);
        assertTrue(link.isOpen);
        assertTrue(link.isChanged);

        assertEquals( 1, nearSensor.distanceContactList.size());
        assertEquals( 0, nearSensor.resetDistanceContactList.size());
        assertTrue( nearSensor.distanceContactList.contains(boss.getCreationIndex()));

        nearSensorSystem.processSensorCollision(playerEntity.getCreationIndex(), boss.getCreationIndex(), "ResetNearSensor",true);
        nearSensorSystem.execute( 0.5F);
        assertTrue(link.pulse);
        assertFalse(link.isOpen);
        assertFalse(link.isChanged);

        assertEquals( 1, nearSensor.distanceContactList.size());
        assertEquals( 1, nearSensor.resetDistanceContactList.size());
        assertTrue( nearSensor.distanceContactList.contains(boss.getCreationIndex()));


        nearSensorSystem.processSensorCollision(playerEntity.getCreationIndex(), boss.getCreationIndex(), "NearSensor",false);
        nearSensorSystem.execute( 0.5F);
        assertTrue(link.pulse);
        assertFalse(link.isOpen);
        assertFalse(link.isChanged);

        assertEquals( 0, nearSensor.distanceContactList.size());
        assertEquals( 1, nearSensor.resetDistanceContactList.size());

        nearSensorSystem.execute( 0.5F);
        assertTrue(link.pulse);
        assertFalse(link.isOpen);
        assertFalse(link.isChanged);

        nearSensorSystem.processSensorCollision(playerEntity.getCreationIndex(), boss.getCreationIndex(), "ResetNearSensor",false);
        nearSensorSystem.execute( 0.5F);
        assertFalse(link.pulse);
        assertTrue(link.isOpen);
        assertTrue(link.isChanged);

        assertEquals(2, sensorsIndex.getEntities(playerEntity.getCreationIndex()).size());
        assertEquals( 0, nearSensor.distanceContactList.size());
        assertEquals( 0, nearSensor.resetDistanceContactList.size());

        nearSensorSystem.execute( 0.5F);
        assertFalse(link.pulse);
        assertFalse(link.isOpen);
        assertFalse(link.isChanged);
        assertEquals(2, sensorsIndex.getEntities(playerEntity.getCreationIndex()).size());
        assertEquals( 0, nearSensor.distanceContactList.size());
        assertEquals( 0, nearSensor.resetDistanceContactList.size());


    }

}
