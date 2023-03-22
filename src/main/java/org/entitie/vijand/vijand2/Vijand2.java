package org.entitie.vijand.vijand2;

import com.github.hanyaeger.api.Coordinate2D;
import org.entitie.vijand.Vijand;
import org.entitie.vijand.vijand1.Vijand1Sprite;

public class Vijand2 extends Vijand {
    public Vijand2(Coordinate2D initialLocation, int health,float sterkte) {
        super(initialLocation, health, sterkte);
        setMotion(2,180);
    }
    protected void setupEntities() {
        //  Hitbox hitbox = new Hitbox();
        Vijand2Sprite vijand2Sprite = new Vijand2Sprite(new Coordinate2D(getWidth()/2,200));
        addEntity(vijand2Sprite);
        System.out.println(vijand2Sprite.getAnchorLocation());
    }
}
