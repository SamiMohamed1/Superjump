package org.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class BewegendPlatform extends DynamicSpriteEntity {


    public BewegendPlatform(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation, new Size(50,50));
    }
}
