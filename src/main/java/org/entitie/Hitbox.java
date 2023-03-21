package org.entitie;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class Hitbox extends RectangleEntity implements Collider {
    private int width;
    private int height;
    public Hitbox(final Coordinate2D initialPosition, int width, int height) {
        super(initialPosition);
        this.width = width;
        this.height = height;
        setWidth(width);
        setHeight(height);
        setFill(Color.TRANSPARENT);
    }
}