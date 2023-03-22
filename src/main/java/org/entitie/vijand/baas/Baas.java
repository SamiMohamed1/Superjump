package org.entitie.vijand.baas;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import org.entitie.Hitbox;
import org.entitie.vijand.Vijand;

public class Baas extends Vijand  {
    public Baas(Coordinate2D initialLocation, int health, float sterkte) {

        super(initialLocation, health, sterkte,new Size(50,50));
    }
    protected void setupEntities() {
       Hitbox hitbox = new Hitbox(new Coordinate2D(0,0),50,50);
       addEntity(hitbox);
        BaasSprite baasSprite = new BaasSprite(new Coordinate2D(0,0));
        addEntity(baasSprite);
        System.out.println(baasSprite.getAnchorLocation());
    }
}
