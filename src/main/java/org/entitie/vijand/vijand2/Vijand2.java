package org.entitie.vijand.vijand2;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import org.entitie.Hitbox;
import org.entitie.vijand.Vijand;
import org.entitie.vijand.vijand1.Vijand1Sprite;

public class Vijand2 extends Vijand {
    public Vijand2(Coordinate2D initialLocation, int health,float sterkte) {
        super(initialLocation, health, sterkte,  new Size(50,50));
        setMotion(2,90);
    }
    protected void setupEntities() {
         Hitbox hitbox = new Hitbox(new Coordinate2D(getWidth()/2,200),50,50);
         addEntity(hitbox);
        Vijand2Sprite vijand2Sprite = new Vijand2Sprite(new Coordinate2D(getWidth()/2,200), new Size(50,50));
        addEntity(vijand2Sprite);
        System.out.println(vijand2Sprite.getAnchorLocation());
    }
    @Override
    public void onCollision(Collider collider) {

    }
}
