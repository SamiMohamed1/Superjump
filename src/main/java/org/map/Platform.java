package org.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public abstract class Platform extends SpriteEntity implements Collider {
    public Platform(Coordinate2D initialLocation, Size size, String resource) {
        super(resource, initialLocation, new Size(50,50));
    }
}
