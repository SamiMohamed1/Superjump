package org.entitie.projectiel;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Projectiel extends DynamicSpriteEntity {
    public Projectiel(Coordinate2D initialLocation, int directie) {
        super("afbeeldingen/slash.png", initialLocation, new Size(50,50));
        setMotion(3,directie);
    }
}
