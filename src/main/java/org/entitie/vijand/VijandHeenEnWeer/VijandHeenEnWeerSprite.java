package org.entitie.vijand.VijandHeenEnWeer;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class VijandHeenEnWeerSprite extends SpriteEntity {
    protected VijandHeenEnWeerSprite(final Coordinate2D Locatie, Size size) {
        super("afbeeldingen/monster2.png", Locatie);
    }
}
