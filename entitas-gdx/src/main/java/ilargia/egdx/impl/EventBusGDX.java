package ilargia.egdx.impl;


import ilargia.egdx.api.EventBus;
import net.engio.mbassy.bus.MBassador;

public class EventBusGDX implements EventBus {

    public MBassador ebus;

    public EventBusGDX(MBassador ebus) {
        this.ebus = ebus;
    }

    @Override
    public <E> void post(E event) {
        ebus.post(event).now();
    }

    @Override
    public <L> void subscribe(L listener) {
        ebus.subscribe(listener);
    }
}
