package org.entitie.vijand;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public class Vijand extends DynamicCompositeEntity {
    public int health;
    public Vijand(Coordinate2D initialLocation, int health) {
        super(initialLocation);
        this.health = health;
    }

    @Override
    protected void setupEntities() {

    }
}
