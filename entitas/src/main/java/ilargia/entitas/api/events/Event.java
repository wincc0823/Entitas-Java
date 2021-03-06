package ilargia.entitas.api.events;

import ilargia.entitas.Context;

import java.util.Set;

public class Event<T> {

    private Set<T> listeners;//ObjectArrayList

    public Event() {
        //this.listeners = Collections.createSet(Object.class);
    }

    public boolean removeListener(T eventHandler) {
        return listeners.remove(eventHandler);
    }

    public T addListener(T eventHandler) {
        listeners.add(eventHandler);
        return eventHandler;
    }

    public Set<T> listeners() {
        return listeners;
    }

    public <P extends Context> void clear() {
        listeners.clear();
    }


}