package com.ilargia.games.entitas.exceptions;

import com.ilargia.games.entitas.BaseContext;


public class ContextEntityIndexDoesNotExistException extends EntitasException {
    public ContextEntityIndexDoesNotExistException(BaseContext pool, String name) {
        super("Cannot get EntityIndex '" + name + "' from pool '" +
                pool + "'!", "No EntityIndex with this name has been added.");
    }
}