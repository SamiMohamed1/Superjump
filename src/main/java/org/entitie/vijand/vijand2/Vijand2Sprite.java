package org.entitie.vijand.vijand2;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Vijand2Sprite extends SpriteEntity {
    protected Vijand2Sprite(final Coordinate2D Locatie, Size size) {
        super("afbeeldingen/monster2.png", Locatie);
    }
}
