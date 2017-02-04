package com.ilargia.games.entitas.group;

import com.ilargia.games.entitas.Entity;
import com.ilargia.games.entitas.api.IComponent;
import com.ilargia.games.entitas.api.IEntity;
import com.ilargia.games.entitas.api.IGroup;
import com.ilargia.games.entitas.api.events.GroupChanged;
import com.ilargia.games.entitas.api.events.GroupUpdated;
import com.ilargia.games.entitas.api.matcher.IMatcher;
import com.ilargia.games.entitas.collector.Collector;
import com.ilargia.games.entitas.events.GroupEvent;
import com.ilargia.games.entitas.exceptions.GroupSingleEntityException;
import com.ilargia.games.entitas.factories.Collections;

import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

public class Group<TEntity extends IEntity> implements IGroup<TEntity> {

    public Class<TEntity> type;
    public Set<GroupChanged> OnEntityAdded = Collections.createSet(GroupChanged.class);
    public Set<GroupChanged> OnEntityRemoved = Collections.createSet(GroupChanged.class);
    public Set<GroupUpdated> OnEntityUpdated = Collections.createSet(GroupUpdated.class);
    UUID id = UUID.randomUUID();
    private IMatcher<TEntity> _matcher;
    private Set<TEntity> _entities; //
    private TEntity[] _entitiesCache;
    private TEntity _singleEntityCache;

    public Group(IMatcher<TEntity> matcher, Class<TEntity> clazz) {
        _entities = Collections.createSet(Entity.class);
        _matcher = matcher;
        type = clazz;

    }

    public static <TE extends Entity> Collector<TE> createCollector(IGroup<TE> group, GroupEvent groupEvent) {
        return new Collector<TE>(group, groupEvent);
    }

    @Override
    public int getCount() {
        return _entities.size();
    }

    @Override
    public IMatcher getMatcher() {
        return _matcher;
    }

    public void handleEntitySilently(TEntity entity) {
        if (_matcher.matches(entity)) {
            addEntitySilently(entity);
        } else {
            removeEntitySilently(entity);
        }
    }

    public void handleEntity(TEntity entity, int index, IComponent component) {
        if (_matcher.matches(entity)) {
            addEntitySilently(entity);
        } else {
            removeEntitySilently(entity);
        }

    }

    public void updateEntity(TEntity entity, int index, IComponent previousComponent, IComponent newComponent) {
        if (_entities.contains(entity)) {
            notifyOnEntityRemoved(entity, index, previousComponent);
            notifyOnEntityAdded(entity, index, previousComponent);
            notifyOnEntityUpdated(entity, index, previousComponent, newComponent);
        }
    }

    public void removeAllEventHandlers() {
        OnEntityAdded.clear();
        OnEntityRemoved.clear();
        OnEntityUpdated.clear();
    }

    @Override
    public Set<GroupChanged> handleEntity(TEntity entity) {
        return (_matcher.matches(entity))
                ? (addEntitySilently(entity)) ? OnEntityAdded : null
                : (removeEntitySilently(entity)) ? OnEntityRemoved : null;

    }

    private boolean addEntitySilently(TEntity entity) {
        boolean added = _entities.add(entity);
        if (added) {
            _entitiesCache = null;
            _singleEntityCache = null;
            entity.retain(this);
        }
        return added;

    }

    void addEntity(TEntity entity, int index, IComponent component) {
        if (addEntitySilently(entity)) {
            notifyOnEntityAdded(entity, index, component);
        }

    }

    private boolean removeEntitySilently(TEntity entity) {
        boolean removed = _entities.remove(entity);
        if (removed) {
            _entitiesCache = null;
            _singleEntityCache = null;
            entity.release(this);
        }

        return removed;
    }

    void removeEntity(TEntity entity, int index, IComponent component) {
        boolean removed = _entities.remove(entity);
        if (removed) {
            _entitiesCache = null;
            _singleEntityCache = null;
            notifyOnEntityRemoved(entity, index, component);
            entity.release(this);
        }

    }

    public boolean containsEntity(TEntity entity) {
        return _entities.contains(entity);
    }

    public TEntity[] getEntities() {
        if (_entitiesCache == null) {
            _entitiesCache = (TEntity[]) java.lang.reflect.Array.newInstance(type, _entities.size());
            int i = 0;
            for (TEntity entity : _entities) {
                _entitiesCache[i] = entity;
                i++;
            }

        }
        return _entitiesCache;

    }

    public TEntity getSingleEntity() {
        if (_singleEntityCache == null) {
            int c = _entities.size();
            if (c == 1) {
                Iterator<TEntity> enumerator = _entities.iterator();
                _singleEntityCache = enumerator.next();
            } else if (c == 0) {
                return null;
            } else {
                throw new GroupSingleEntityException(this);
            }
        }
        return _singleEntityCache;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;

        Group<?> group = (Group<?>) o;

        if (_matcher != null ? !_matcher.equals(group._matcher) : group._matcher != null) return false;
        if (_entities != null ? !_entities.equals(group._entities) : group._entities != null) return false;
        return type != null ? type.equals(group.type) : group.type == null;
    }

    @Override
    public int hashCode() {
        int result = _matcher != null ? _matcher.hashCode() : 0;
        result = 31 * result + id.hashCode();
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Group{" +
                "_matcher=" + _matcher +
                ", _entities=" + _entities +
                ", _singleEntityCache=" + _singleEntityCache +
                ", type=" + type +
                '}';
    }

    public void clearEventsListener() {
        if (OnEntityAdded != null) OnEntityAdded.clear();
        if (OnEntityRemoved != null) OnEntityRemoved.clear();
        if (OnEntityUpdated != null) OnEntityUpdated.clear();

    }

    public void OnEntityAdded(GroupChanged<TEntity> listener) {
        if (OnEntityAdded != null) {
            OnEntityAdded = Collections.createSet(GroupChanged.class);
        }
        OnEntityAdded.add(listener);
    }

    public void OnEntityUpdated(GroupUpdated<TEntity> listener) {
        if (OnEntityUpdated != null) {
            OnEntityUpdated = Collections.createSet(GroupUpdated.class);
        }
        OnEntityUpdated.add(listener);
    }

    public void OnEntityRemoved(GroupChanged<TEntity> listener) {
        if (OnEntityRemoved != null) {
            OnEntityRemoved = Collections.createSet(GroupChanged.class);
        }
        OnEntityRemoved.add(listener);
    }


    public void notifyOnEntityAdded(TEntity entity, int index, IComponent component) {
        if (OnEntityAdded != null) {
            for (GroupChanged<TEntity> listener : OnEntityAdded) {
                listener.changed(this, entity, index, component);
            }
        }
    }

    public void notifyOnEntityUpdated(TEntity entity, int index, IComponent component, IComponent newComponent) {
        if (OnEntityUpdated != null) {
            for (GroupUpdated<TEntity> listener : OnEntityUpdated) {
                listener.updated(this, entity, index, component, newComponent);
            }
        }
    }

    public void notifyOnEntityRemoved(TEntity entity, int index, IComponent component) {
        if (OnEntityRemoved != null) {
            for (GroupChanged<TEntity> listener : OnEntityRemoved) {
                listener.changed(this, entity, index, component);
            }
        }
    }


}