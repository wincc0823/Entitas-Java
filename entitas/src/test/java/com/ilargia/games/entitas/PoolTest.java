package com.ilargia.games.entitas;

import com.ilargia.games.entitas.exceptions.EntityIsNotDestroyedException;
import com.ilargia.games.entitas.exceptions.PoolDoesNotContainEntityException;
import com.ilargia.games.entitas.exceptions.PoolStillHasRetainedEntitiesException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class PoolTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private BasePool pool;
    private Entity entity;


    @Before
    public void setUp() throws Exception {
        pool = new BasePool(100);
        entity = pool.createEntity();

    }

    @Test
    public void OnEntityCreatedTest() {
        pool.OnEntityCreated = ((BasePool pool, Entity e) -> assertTrue(e.isEnabled()));
        entity = pool.createEntity();
    }

    @Test
    public void hasEntityTest() {
        assertTrue(pool.hasEntity(entity));

    }

    @Test
    public void getCountTest() {
        assertEquals(1, pool.getCount());

    }

    @Test
    public void getEntitiesTest() {
        assertEquals(1, pool.getEntities().length);

    }

    @Test
    public void destroyEntityTest() {
        pool.destroyEntity(entity);
        assertEquals(0, pool.getEntities().length);

    }

    @Test
    public void OnEntityDestroyedTest() {
        pool.OnEntityWillBeDestroyed = ((BasePool pool, Entity e) -> assertTrue(e.isEnabled()));
        pool.OnEntityDestroyed = ((BasePool pool, Entity e) -> assertFalse(e.isEnabled()));
        pool.destroyAllEntities();
        assertEquals(0, pool.getCount());

    }

    @Test
    public void getReusableEntitiesCountTest() {
        Entity entity2 = pool.createEntity();
        pool.destroyEntity(entity2);
        assertEquals(1, pool.getReusableEntitiesCount());

    }

    @Test
    public void getRetainedEntitiesCountTest() {
        entity.retain(new Object());
        pool.destroyEntity(entity);
        assertEquals(1, pool.getRetainedEntitiesCount());

    }

    @Test(expected = PoolStillHasRetainedEntitiesException.class)
    public void PoolStillHasRetainedEntitiesExceptionTest() {
        entity.retain(new Object());
        pool.destroyAllEntities();


    }

    @Test(expected = PoolDoesNotContainEntityException.class)
    public void PoolDoesNotContainEntityExceptionTest() {
        Entity entity2 = new Entity(100, null, null);
        pool.destroyEntity(entity2);

    }

    @Test
    public void onEntityReleasedTest() {
        entity.destroy();
        entity.release(pool);

        assertEquals(1, pool.getReusableEntitiesCount());
    }

    @Test(expected = EntityIsNotDestroyedException.class)
    public void EntityIsNotDestroyedExceptionTest() {
        entity.release(pool);
    }

    //@Test
    public void getGroupTest() {
//        pool.getEntities(Matcher.AllOf(1, 2));
//        pool.getGroup(Matcher.AllOf(1)).getEntities();
    }

}
