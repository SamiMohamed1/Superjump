package org.entitie.projectiel;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Projectiel extends DynamicSpriteEntity implements Collided, Collider {

    private  int sterkte;

    public Projectiel(Coordinate2D initialLocation, int directie, int sterkte) {
        super("afbeeldingen/slash.png", initialLocation, new Size(50,50));
        setMotion(3,directie);
        this.sterkte = sterkte;

    }

    @Override
    public void onCollision(Collider collider) {
        if(collider instanceof ProjectielCollision projectielCollision){
            projectielCollision.ProjectilCollision(sterkte);
            remove();
        }
    }
}
