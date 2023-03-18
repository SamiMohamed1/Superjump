package org.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Grond extends SpriteEntity implements Collided, Collider {
    public Grond(Coordinate2D initialLocation, Size size, String resource) {
        super(resource, initialLocation, size);
    }

    @Override
    public void onCollision(Collider collider) {

    }
}
