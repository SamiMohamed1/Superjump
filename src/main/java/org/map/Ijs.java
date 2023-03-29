package org.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;

public class Ijs extends Platform implements  Collider {
    public Ijs(Coordinate2D initialLocation, Size size, String resource) {
        super(initialLocation, size, resource);
    }


}
