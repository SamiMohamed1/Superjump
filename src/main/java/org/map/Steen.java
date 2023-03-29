package org.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;

public class Steen extends Platform implements  Collider {
    public Steen(Coordinate2D initialLocation, Size size, String resource) {
        super(initialLocation, size, resource);
    }

}
