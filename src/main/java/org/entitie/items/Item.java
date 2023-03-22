package org.entitie.items;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public abstract class Item extends SpriteEntity {


    public Item(Coordinate2D initialLocation, Size size, String resource) {
        super(resource, initialLocation, new Size(50,50));
    }
}
