package org.entitie.vijand.vijand1;

import com.github.hanyaeger.api.Coordinate2D;
import org.entitie.vijand.Vijand;
import org.entitie.vijand.baas.BaasSprite;
import org.entitie.vijand.vijand2.Vijand2;
import org.entitie.vijand.vijand2.Vijand2Sprite;

public class Vijand1 extends Vijand {
    private int richting;
    public Vijand1(Coordinate2D initialLocation,int richting, int health, float sterkte) {
        super(initialLocation, health, sterkte);
        this.richting = richting;
        setMotion(2,richting);
    }
    protected void setupEntities() {
        //  Hitbox hitbox = new Hitbox();
        Vijand1Sprite vijand1Sprite = new Vijand1Sprite(new Coordinate2D(getWidth()/2,200));
        addEntity(vijand1Sprite);
        System.out.println(vijand1Sprite.getAnchorLocation());
    }
}
