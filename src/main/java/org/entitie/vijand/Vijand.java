package org.entitie.vijand;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public abstract class Vijand extends DynamicCompositeEntity {
    private int health;
    private float sterkte;
    public Vijand(Coordinate2D initialLocation, int health, float sterkte) {
        super(initialLocation);
        this.health = health;
        this.sterkte = sterkte;
    }


    protected abstract void setupEntities();
}
