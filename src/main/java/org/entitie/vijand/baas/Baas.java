package org.entitie.vijand.baas;

import com.github.hanyaeger.api.Coordinate2D;
import org.entitie.vijand.Vijand;

public class Baas extends Vijand  {
    public Baas(Coordinate2D initialLocation, int health, float sterkte) {

        super(initialLocation, health, sterkte);
    }
    protected void setupEntities() {
      //  Hitbox hitbox = new Hitbox();
        BaasSprite baasSprite = new BaasSprite(new Coordinate2D(10,10));
        addEntity(baasSprite);
        System.out.println(baasSprite.getAnchorLocation());
    }
}
