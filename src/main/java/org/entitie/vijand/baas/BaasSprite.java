package org.entitie.vijand.baas;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class BaasSprite extends SpriteEntity {
    protected BaasSprite(final Coordinate2D Locatie) {
        super("afbeeldingen/MonsterBoss.png",Locatie);
        System.out.println("plaatje");
    }
}