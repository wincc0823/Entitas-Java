package com.ilargia.games.entitas.api.matcher;

import com.ilargia.games.entitas.api.IEntity;

public interface ICompoundMatcher<TEntity extends IEntity> extends IMatcher<TEntity> {

    int[] getAllOfIndices();

    int[] getAnyOfIndices();

    int[] getNoneOfIndices();

}